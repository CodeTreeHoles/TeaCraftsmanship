<template>
  <div>
    <div class="bg">
      <Title2></Title2>
      <div id="main">
        <br>
        <!-- <div class="fl img"></div> -->
        <div class="content">
          <el-form label-position="right" :label-width="dynamicLabelWidth" :model="user">
            <el-form-item label="用户名:">
              <el-input v-model="user.name" placeholder="请输入你的用户名"></el-input>
            </el-form-item>
            <el-form-item label="密码:">
              <el-input v-model="user.password" placeholder="请输入你的密码" show-password></el-input>
            </el-form-item>
            <el-form-item label="邮箱:">
              <el-input v-model="user.email" placeholder="请输入你的邮箱号" show-password></el-input>
            </el-form-item>
            <el-form-item label="个人简介:">
              <el-input type="textarea" v-model="user.personalProfile"></el-input>
            </el-form-item>
            <el-form-item label="性别">
              <el-select v-model="user.sex" placeholder="请选择您的性别" style="width: 100%">
                <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="验证码:">
              <el-input v-model="captcha" placeholder="验证码" :disabled="c">
                <template slot="append">
                  <el-button class="captcha-btn" @click="getCaptcha"
                    :disabled="disableBtn">{{ buttonText}}</el-button>
                  </template>
              </el-input>
            </el-form-item>
            <el-form-item class="b">
              <el-button class="btn" @click="register()">注册</el-button>
              <router-link style="color: #6e6452" to="/login" class="fr">没有账号？去登录</router-link>
            </el-form-item>
          </el-form>
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
      user: {
        name: "",
        password: "",
        personalProfile: "",
        email: "",
        sex: "",
      },
      buttonText: "获取验证码",
      disableBtn: false,
      countDown: 60,
      captcha: "",
      c: true,
      options: [
        {
          value: "男",
          label: "男",
        },
        {
          value: "女",
          label: "女",
        },
      ],
      value: "",
    };
  },
  components: {
    Title2
  },
  methods: {
    register() {
      if (
        this.user.name == "" ||
        this.user.password == "" ||
        this.captcha == ""
      ) {
        alert("信息不全");
      } else {
        instance
          .post("/user/enroll", this.user, {
            params: { captcha: this.captcha },
          })
          .then((res) => {
            if (res.code == 1) {
              alert(res.message);
            } else {
              alert(res.data);
            }
          });
      }
    },
    getCaptcha() {
      const email = this.user.email;
      if (email) {
        // 禁用按钮
        this.disableBtn = true;

        // 开始倒计时
        let timer = setInterval(() => {
          this.countDown--;
          this.buttonText = `${this.countDown} 秒后重试`;
          if (this.countDown <= 0) {
            clearInterval(timer);
            this.countDown = 60;
            this.buttonText = '获取验证码';
            this.disableBtn = false; // 启用按钮
          }
        }, 1000);

        // alert(email);
        this.c = false;
        instance
          .post("user/enroll/captcha", email, {
            headers: {
              "Content-Type": "application/json",
            },
          })
          .then((result) => {
            alert(result.data);
          });
      } else {
        alert("请填写邮箱号");
      }
    },
  },
  mounted() {
    // this.login();
  },
  computed: {
    dynamicLabelWidth() {
      // 在这里根据屏幕宽度动态计算 label 的宽度
      if (window.innerWidth < 500) {
        return "5rem"; // 在小屏幕设备上设置较小的 label 宽度
      } else {
        return "8rem"; // 在大屏幕设备上设置较大的 label 宽度
      }
    },
  },
};
</script>

<style scoped>
.bg {
  background: url("https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E7%99%BB%E5%BD%95.jpg");
}

#main {
  width: 80%;
  margin: auto;
  min-height: calc(100vh - 121px);
  text-align: center;
  /* background: #999; */
}

.fl {
  float: left;
}

.fr {
  float: right;
}

.img {
  margin: 4%;
  width: 42%;
  height: 50vh;
  background-image: url("https://four-treasures-for-study.oss-cn-hangzhou.aliyuncs.com/Register/%E4%B9%A6%E6%B3%95.jpg");
  background-size: cover;
  background-position: center;
}

.content {
  width: 34%;
  padding: 2%;
  padding-bottom: 5px;
  padding-right: 8%;
  min-height: 50vh;
  background: #eee;
  border-radius: 5px;
  box-shadow: 0px 0px 5px #000;
  margin: auto;
  /* margin-right: 4%; */
  margin-top: 4%;
}

.btn {
  background: #6a7e6b;
  color: #fff;
  border: 0;
}

.btn:hover {
  background: #6c766c;
  color: #fff;
  border: 0;
}

.btn:focus {
  background: #6c766c;
  color: #fff;
  border: 0;
}

@media screen and (max-device-width: 500px) {
  .img {
    display: none;
  }

  .content {
    float: none;
    width: 92%;
    margin: auto;
  }

  #main {
    padding-top: 2em;
    height: calc(100vh - 60px - 2em);
  }
}
</style>