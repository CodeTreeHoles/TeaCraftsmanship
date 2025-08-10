<template>
  <div id="b">
    <div id="bg">
      <Title2></Title2>
      <div id="main">
        <!-- <h1>茶语论坛</h1> -->
        <br />
        <div class="hand"></div>
        <br />

        <div class="w">
          <!-- <span>{{ localUserName }}</span> -->
          <span v-if="isUnfold" type="text" class="fr ch" @click="clearedForm" style="margin-left: 5em;">发表你的言论</span>
          <span v-if="!isUnfold" type="text" class="fr ch" @click="clearedForm" style="margin-left: 5em;">取消回复</span>
        </div>
        <el-form class="demo-form-inline input" :model="formInline">
          <el-form-item>
            <el-input class="input-content" :disabled="isLogin" v-model="form.content"
              :placeholder="getTarget"></el-input>
            <el-button class="input-button btn" @click="send()">
              <span v-if="isUnfold">发表</span>
              <span v-if="!isUnfold">回复</span>
            </el-button>
          </el-form-item>
        </el-form>

        <div class="comments">

          <div class="comment" v-for="(item, index) in comments" :key="index">
            <div class="comment-title">
              <h4>{{ item.userName }}</h4>
            </div>
            <div class="comment-content fz14" @click="clickComment(item.userName, item.id)">
              <span>{{ item.content }}</span>
              <span class="fr comment-time">{{ item.createTime }}</span>
            </div>
            <div v-if="item.showSubComments">
              <div class="sub_comment" v-for="(subComment, subIndex) in item.subComments" :key="subIndex">
                <div class="comment-title">
                  <h4>
                    {{ subComment.userName }}
                    <span>:回复{{ subComment.target }}</span>
                  </h4>
                </div>
                <div class="comment-content" @click="clickComment(subComment.userName, subComment.pid)">
                  <span>{{ subComment.content }}</span>
                  <span class="fr comment-time">{{
                    subComment.createTime
                  }}</span>
                </div>
              </div>
            </div>
            <div v-if="!item.showSubComments">
              <span class="fr fz14 unfold ch" @click="unfold(item)">展开⬇</span>
            </div>
            <div v-if="item.showSubComments">
              <span class="fr fz14 unfold ch" @click="withdraw(item)">收回⬆</span>
            </div>
            <br />
          </div>
        </div>


      </div>
    </div>
  </div>
</template>

<script>
import instance from "@/api/home";
import Title2 from "../Title2.vue";
export default {
  data() {
    return {
      formInline: {},
      // isUnfold:Array(this.items.length).fill(true),
      form: {
        userId: null,
        pid: null,
        target: null,
        content: null,
      },
      comments: [],
      subComments: [],
      test: [],
      commentComponent: 0
    };
  },
  components: {
    Title2
  },
  computed: {
    isLogin() {
      return localStorage.getItem("userId") == null;
    },
    localUserName() {
      if (localStorage.getItem("username") == null) {
        return "游客"
      }
      return "用户：" + localStorage.getItem("username");
    },
    isUnfold() {
      return this.form.pid == null;
    },
    getTarget() {
      if (localStorage.getItem("username") == null) {
        return "请先登录"
      }
      if (this.form.target == null) {
        return "请输入你的内容";
      }
      return "回复：" + this.form.target;
    },
  },
  methods: {
    getSubordinateComment(pid, index) {
      // 在父评论项中调用此方法，并将返回的数据保存到 comments[index].subComments 中
      instance.get("/comment/" + pid)
        .then((res) => {
          console.log(res.data.data);
          // 使用 Vue.set 方法确保响应式更新
          this.$set(this.comments[index], "subComments", res.data.data);
        })
        .catch((error) => {
          console.error("获取评论失败：", error);
          // 如果获取评论失败，将 subComments 设置为空数组
          this.$set(this.comments[index], "subComments", []);
        });
    },
    unfold(item) {
      const pid = item.id;
      const commentGroup = this.subComments.find(
        (commentGroup) => commentGroup.pid === pid
      );
      //判断本地是否有这个子品论,没有则向后端获取
      if (commentGroup != null) {
        this.$set(item, "subComments", commentGroup.comment);
      } else {
        instance.get("/comment/" + pid).then((res) => {
          const commentGroup = {
            pid: pid,
            comment: res.data,
          };
          this.subComments.push(commentGroup);
          this.$set(item, "subComments", commentGroup.comment);
        });
      }
      this.$set(item, "showSubComments", true);
    },
    withdraw(item) {
      item.showSubComments = false;
    },
    clickComment(target, pid) {
      this.form.pid = pid;
      this.form.target = target;
    },
    clearedForm() {
      if (localStorage.getItem("userId") == null) {
        alert("请先登录");
        return;
      }
      this.form.target = null;
      this.form.pid = null;
    },
    getFormattedTime() {
      const now = new Date();
      const year = now.getFullYear();
      const month = String(now.getMonth() + 1).padStart(2, '0');
      const date = String(now.getDate()).padStart(2, '0');
      const hours = String(now.getHours()).padStart(2, '0');
      const minutes = String(now.getMinutes()).padStart(2, '0');
      const seconds = String(now.getSeconds()).padStart(2, '0');
      const formattedTime = `${year}-${month}-${date} ${hours}:${minutes}:${seconds}`;
      return formattedTime;
    },

    send() {
      if (localStorage.getItem("userId") == null) {
        alert("没有登录")
        return
      }

      this.form.userId = localStorage.getItem("userId");

      // 设置请求头
      const headers = {
        'Content-Type': 'application/json',
        'token': localStorage.getItem('jwt')
      };



      instance.post("/comment", this.form, {
        headers: headers // 将 headers 对象传递给请求
      })



      const comment = Object.assign({}, this.form);
      comment.userName = localStorage.getItem('username');
      comment.createTime = this.getFormattedTime();
      if (this.form.pid == null) {
        this.comments.push(comment)
      } else {
        window.location.reload();
      }
      this.form.content = null;
      this.form.pid = null;
      this.form.target = null;
      // window.location.reload();
    },
  },
  mounted() {
    instance.get("/comment/list").then((res) => {
      this.comments = res.data;
    });
    // this.getComment();
  },
};
</script>
<style scoped>
h1 {
  text-align: center;
}

.w {
  width: 80%;
  margin: auto;
}

#main {
  margin: auto;
  width: 80%;
  height: calc(100vh - 121px - 10vh);
  /* padding-top: 5vh; */
  /* padding-bottom: 5vh; */
  min-height: calc(100vh - 121px);
  /* height: auto; */
  /* background: #aaa; */
}
.hand{
  background: url("../../assets/颜文字.png");
  width: 10em;
  height: 2em;
  margin: auto;
  background-size: cover;
}
#bg {
  background-size:cover !important;
  background-position: center;
  background: url("https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%AE%BA%E5%9D%9B.jpg");
}

.fr {
  float: right;
}

.comments {
  width: 80%;
  margin: auto;

  /* border: black 1px solid; */
}

.unfold {
  margin-left: 75%;
}

.input {
  width: 80%;
  margin: auto;
  text-align: center;
  /* position: absolute; */
  padding-top: 10px;
  /* bottom: 10px; */
  /* left: calc((50% - 40% * 0.8)); */
  /* background-image: url("https://four-treasures-for-study.oss-cn-hangzhou.aliyuncs.com/Forum/%E8%83%8C%E6%99%AF%E5%9B%BE%E7%89%87.png"); */
}

.input-content {
  width: 91%;
}

.input-button {
  width: 7%;
}

.sub_comment {
  width: 97.5%;
  /* border: black 1px solid; */
  padding: 5px;
  margin-left: 2%;
}

.comment {
  /* border: black 1px solid; */
  margin: 5px;
  padding: 5px;
  background-color: #fff;
  box-shadow: 0px 0px 5px #000;
  /* background: url("@/assets/c36.png"); */
  opacity: 0.8;
}

.comment-content:hover {
  cursor: pointer;
  background: #eee;
}

.fz14 {
  font-size: 14px;
}

.comment-time {
  font-size: 12px;
  color: #555;
}

.ch:hover {
  cursor: pointer;
}

.btn {
  background: #9bda9788;
  color: #fff;
  border: 0;
  margin-left: 1%;
  box-shadow: 0px 0px 5px #000;
}

@media screen and (max-device-width: 500px) {
  #main {
    min-height: calc(100vh - 121px + 60px);
  }

  .input-content {
    width: 70%;
  }

  .w {
    width: 95%;
  }

  .input-button {
    width: 25%;
  }

  .comments {
    width: 95%;
  }

  .input {
    width: 95%;
    /* position: absolute; */
    /* left: calc((50% - 47.5% * 0.8)); */
  }


}
</style>