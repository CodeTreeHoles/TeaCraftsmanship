<template>
  <div id="Title" :class="{ 'margin-Title': Change }">
    <div class="title" :style="{ background: bg }" :class="{ 'vw-title': Change }">
      <router-link to="/home"><img class="logo" src="../assets/数媒logo.png" alt="" /></router-link>
      <span class="center">从徽茶到世界 · 品味文化 ·共筑命运</span>
      <div class="dress">
        <router-link to="/home">
          <div @mouseover="hidefourTea()">首页</div>
        </router-link>

        <div @mouseover="showfourTeaInfo = 'first'">徽茶</div>

        <router-link to="/namelist">
          <div @mouseover="hidefourTea()">名单</div>
        </router-link>
        <div @mouseover="showfourTeaInfo = 'second'">寻迹</div>

        <router-link to="/forum">
          <div @mouseover="hidefourTea()">茶语论坛</div>
        </router-link>
        <router-link to="/AI">
          <div @mouseover="hidefourTea()">AI茶画</div>
        </router-link>
        <router-link to="/about">
          <div @mouseover="hidefourTea()">何以徽茶</div>
        </router-link>
        <div>
          <router-link to="/login" v-if="!isLogin">
            <span>登录</span>
          </router-link>
          <div @click="showLoginModal" class="isLogin" v-if="isLogin" :style="{ backgroundImage: 'url(' + avatar + ')' }">
          </div>
          <!-- 
          <router-link to="/login">
            <span v-if="!isLogin">登录</span>
            <div class="isLogin" v-if="isLogin"></div>
          </router-link> -->
        </div>
      </div>
    </div>
    <popup v-if="showModal" @close="showLoginModal"></popup>
    <div class="fourTea-info" v-if="showfourTeaInfo === 'first'" @mouseleave="hidefourTea()"
      :class="{ 'vw-tea-info': Change }">
      <div class="fourTea-box">
        <router-link to="/huangshanmaofengtea">黄山毛峰</router-link>
        <router-link to="/keemunblacktea">祁门红茶</router-link>
        <router-link to="/taipinghoukuitea">太平猴魁</router-link>
        <router-link to="/guapiantea">六安瓜片</router-link>
        <router-link to="/huoshanhuangyatea"> 霍山黄芽</router-link>
        <router-link to="/gegongblacktea"> 葛公红茶</router-link>
        <router-link to="/yuesaitrylandtea"> 岳西翠兰</router-link>
        <router-link to="/jinshanrainteatea"> 金山时雨</router-link>
      </div>
    </div>
    <div class="fourTea-info" v-if="showfourTeaInfo === 'second'" @mouseleave="hidefourTea()"
      :class="{ 'vw-tea-info': Change }">
      <div class="fourTea-box">
        <router-link v-for="(name, index) of names" :key="index"
          :to="{ path: '/map', query: { componentName: name } }">{{ name }}</router-link>
      </div>
    </div>

    <div class="down-btn" :style="{ transform: Hrotate }" @click="onBtn()"></div>

    <div class="collapse" v-if="isCollapse">
      <div>
        <div @click="onBtn()"><router-link to="/home">首页</router-link></div>
        <div @click="onBtn()">
          <router-link to="/forum">茶语论坛</router-link>
        </div>
        <div @click="onBtn()"><router-link to="/login">登录</router-link></div>
        <div @click="onBtn()">
          <router-link to="/register">注册</router-link>
        </div>
        <div @click="onBtn()">
          <router-link to="/namelist">名单</router-link>
        </div>
        <div @click="onBtn()"><router-link to="/about">何以徽茶</router-link></div>
        <div>
          <span>寻迹</span>
          <div class="down" :style="{ transform: rotate[0] }" @click="isDown(0)"></div>
          <div v-if="window == 0" class="window">
            <div v-for="(name, index) of names" :key="index" @click="onBtn()">
              <router-link :to="{ path: '/map', query: { componentName: name } }">{{ name }}</router-link>
            </div>
          </div>
        </div>
        <div>
          <span>徽茶</span>
          <div class="down" :style="{ transform: rotate[2] }" @click="isDown(2)"></div>
          <div v-if="window == 2" class="window">
            <div @click="onBtn()">
              <router-link to="/huangshanmaofengtea">黄山毛峰</router-link>
            </div>
            <div @click="onBtn()">
              <router-link to="/keemunblacktea">祁门红茶</router-link>
            </div>
            <div @click="onBtn()">
              <router-link to="/taipinghoukuitea">太平猴魁</router-link>
            </div>
            <div @click="onBtn()">
              <router-link to="/guapiantea">六安瓜片</router-link>
            </div>
            <div @click="onBtn()">
              <router-link to="/huoshanhuangyatea"> 霍山黄芽</router-link>
            </div>
            <div @click="onBtn()">
              <router-link to="/gegongblacktea"> 葛公红茶</router-link>
            </div>
            <div @click="onBtn()">
              <router-link to="/yuesaitrylandtea"> 岳西翠兰</router-link>
            </div>
            <div @click="onBtn()">
              <router-link to="/jinshanrainteatea"> 金山时雨</router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Title",
  data() {
    return {
      showModal: false,
      Change: false,
      showfourTeaInfo: null,
      activeNames: ["1"],
      bg: "rgba(20,20, 20, 0.2)",
      Hrotate: "rotate(0deg)",
      rotate: ["rotate(0deg)"],
      window: -1,
      isCollapse: false,
      names: ["黄山", "池州", "安庆", "六安", "宣城"],
    };
  },
  computed: {
    isLogin() {
      return (
        localStorage.getItem("userId") != null &&
        localStorage.getItem("userId") != ""
      );
    },
    avatar() {
      return localStorage.getItem("avatar")
    }
  },
  methods: {
    showLoginModal() {
      this.showModal = !this.showModal;
    },
    // closeModal() {
    //   this.showModal = false;
    // },
    hidefourTea() {
      this.showfourTeaInfo = null;
    },
    onBtn() {
      this.Hrotate =
        this.Hrotate == "rotate(180deg)" ? "rotate(0deg)" : "rotate(180deg)";
      this.$forceUpdate();
      this.isCollapse = !this.isCollapse;
      this.bg = this.bg == "#333" ? "rgba(20,20, 20, 0.2)" : "#333";
    },
    isDown(index) {
      for (let i = 0; i < this.rotate.length; i++) {
        if (i !== index) {
          this.rotate[i] = "rotate(0deg)";
        }
      }
      this.rotate[index] =
        this.rotate[index] == "rotate(180deg)"
          ? "rotate(0deg)"
          : "rotate(180deg)";
      this.$forceUpdate();

      if (this.window == index) {
        this.window = -1;
      } else {
        this.window = index;
      }
    },
  },
  mounted() {
    // 初始化 Change 的值
    // this.Change = this.$route.path !== "/home";
    // 监听窗口大小变化
  },
  //当刷新页面时，Vue 应用会重新加载，并且重新执行 Vue 实例的创建和初始化过程。
  watch: {
    $route(newvalue, old) {
      // 监听路由变化，更新 Change 的值
      // this.Change = newvalue.path !== "/home";
    },
  },
};
</script>

<style scoped>
/* .margin-Title {
  margin-left: 10%;
  margin-right: 10%;
} */

.title {
  position: absolute;
  width: 100%;
  height: 60px;
  display: flex;
  align-items: center;
  border-bottom: 1px solid white;
  background: rgba(20, 20, 20, 0.2);
  box-shadow: 0px 0px 1px white;
}

.vw-title {
  width: 80%;
}

.logo {
  border-radius: 50%;
  width: 50px;
  margin-left: 40px;
  height: 50px;
}

.isLogin {
  border-radius: 50%;
  width: 50px;
  margin-left: 40px;
  margin-top: 5px;
  height: 50px;
  /* background: url("../assets/用户头像.png"); */
  background-position: center;
  background-size: cover;
}

.center {
  margin-left: 30px;
  width: 50%;
}

.dress {
  display: flex;
  width: 50%;
  color: white;
}

.dress>a,
.dress>div {
  flex: 1;
  height: 60px;
  line-height: 60px;
  text-align: center;
  cursor: pointer;
}

.dress>a div,
.dress>div a {
  color: white;
}

.fourTea-info {
  color: white;
  position: a;
  top: 60px;
  height: 60px;
  position: absolute;
  background: rgba(20, 20, 20, 0.2);
  box-shadow: 0px 0px 1px white;
  width: 100%;
}

.vw-tea-info {
  width: 80%;
}

.fourTea-info .fourTea-box {
  display: flex;
  height: 50px;
  align-items: center;
  margin-left: 45%;
}

.fourTea-info .fourTea-box a {
  width: 100px;
  color: white;
  text-align: center;
}

.fourTeaName {
  text-align: center;
  width: 115px;
  color: white;
}

.forum-container {
  position: relative;
  margin-left: 25px;
  cursor: pointer;
}

.forum {
  width: 40px;
  margin-bottom: 10px;
}

.fourTea-Language {
  color: white;
  top: 39px;
  left: 0;
}

span {
  color: white;
}

.down-btn {
  width: 60px;
  position: fixed;
  left: calc(100vw - 60px);
  height: 60px;
  background: url("../assets/向下箭头.png");
  float: right;
  display: none;
  background-position: center;
  background-size: cover;
  outline: none;
  /* 去除按钮获得焦点时的默认边框 */
}

@media screen and (min-device-width: 2000px) {

  .title {
    height: 100px;

  }

  div {
    font-size: 23px;
  }

  .fourTea-info {
    top: 100px;
    height: 100px;
  }

  .fourTea-info .fourTea-box {
    display: flex;
    height: 100px;
    align-items: center;
    margin-left: 45%;
  }
  .fourTea-info .fourTea-box a {
    width: 140px;
  }
  .logo {
  border-radius: 50%;
  width: 90px;
  margin-left: 40px;
  height: 90px;
}
}

@media screen and (max-device-width: 500px) {

  .title{
    position: fixed;
    z-index: 1;
  }
  .fourTea-info,
  .dress {
    display: none;
  }

  .logo {
    margin-left: 0;
  }

  .center {
    font-size: 15px;
    width: 9em;
  }

  .down-btn {
    display: block;
    z-index: 2;
  }

  .collapse {
    position: fixed;
    width: 100%;
    top: 60px;
    height: calc(100vh - 60px);
    background: #333;
    z-index: 3;
    font-size: 2.5vh;
    line-height: 2em;
  }

  .collapse>div {
    background: #fff;
    padding-bottom: 1px;
  }

  .collapse>div>div {
    background: #333;
    margin-bottom: 2px;
    /* display: flex; */
  }

  .collapse>div>div>a,
  .collapse>div>div>span {
    padding-left: 12px;
    color: #fff;
  }

  .down {
    float: right;
    background: url("../assets/向下箭头-白.png");
    /* background: red; */
    width: 1.2em;
    height: 1.2em;
    margin: 0.4em;
    /* margin: auto; */
    outline: none;
    background-position: center;
    background-size: cover;
  }

  .window {
    background: #fff;
  }

  .window div a,
  .window div {
    background: #222;
    color: white !important;
    margin-top: 2px;
    padding-left: 6px;
  }
}
</style>
