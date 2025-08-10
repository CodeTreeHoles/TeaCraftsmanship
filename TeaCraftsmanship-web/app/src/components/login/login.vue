<template>
    <div>
      <div class="bg">
        <Title2></Title2>
        <div id="main">
          <!-- <div class="fl img"></div> -->
          <br>
          <div class="content">
            <el-form
              label-position="right"
              :label-width="dynamicLabelWidth"
              :model="user"
            >
              <el-form-item label="用户名:">
                <el-input
                  v-model="user.name"
                  placeholder="请输入你的用户名"
                ></el-input>
              </el-form-item>
              <el-form-item label="密码:">
                <el-input
                  v-model="user.password"
                  placeholder="请输入你的密码"
                  show-password
                ></el-input>
              </el-form-item>
              <el-form-item class="b">
                <el-button class="btn" @click="login()">登录</el-button>
                <el-button class="btn" @click="exit()">退出</el-button>
                <!-- <el-button class="btn" @click="login()"><router-link to="/register">注册</router-link></el-button> -->
                <router-link style="color: #6e6452" to="/register" class="fr"
                  >没有账号？去注册</router-link
                >
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
        },
        wlabel: "8rem",
      };
    },
    components:{
      Title2
    },
    methods: {
      login() {
        instance.post("/user/login", this.user).then((res) => {
          if (res.code == 0) {
            alert("登录成功");
  
            // 存储 jwt 和用户信息到 localStorage

            // console.log(res);
            localStorage.setItem("jwt", res.data.jwt);
            // const user = res.data.user
            // user.password = this.user.password
            // localStorage.setItem("user", user);
            // console.log(user);
            localStorage.setItem("userId", res.data.id);
            if(res.data.avatar == null || res.data.avatar == ""){
              localStorage.setItem("avatar", "https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E7%94%A8%E6%88%B7%E5%A4%B4%E5%83%8F.png");
            }else{
              localStorage.setItem("avatar", res.data.avatar);
            }
            localStorage.setItem("username", this.user.name);
            localStorage.setItem("password", this.user.password);

            // 计算过期时间（当前时间 + 1小时）
            let expireTime = new Date().getTime() + 3600000;
            localStorage.setItem("expireTime", expireTime);
  
            // 检查过期时间，并设置定时器
            let checkExpiration = () => {
              let currentTime = new Date().getTime();
              let storedExpireTime = localStorage.getItem("expireTime");
  
              if (storedExpireTime && currentTime > parseInt(storedExpireTime)) {
                // 移除过期的 jwt 和用户信息
                localStorage.removeItem("jwt");
                localStorage.removeItem("userId");
                localStorage.removeItem("username");
                localStorage.removeItem("password");
                console.log("已经删除");
                window.location.reload();
              } else {
                // 设置新的定时器
                setTimeout(
                  checkExpiration,
                  parseInt(storedExpireTime) - currentTime
                );
              }
            };
  
            // 执行定时检查
            checkExpiration();
  
            // 跳转到 home 页面
            this.$router.push("/home");
            window.location.reload();
          } else {
            alert("登录失败");
          }
        });
      },
      exit() {
        alert("退出账号");
        localStorage.removeItem("jwt");
        localStorage.removeItem("userId");
        localStorage.removeItem("username");
        localStorage.removeItem("password");
        window.location.reload();
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
    height: calc(100vh - 121px);
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
    background-image: url("https://four-treasures-for-study.oss-cn-hangzhou.aliyuncs.com/Login/%E4%B9%A6%E6%B3%95.jpg");
    background-size: cover;
    background-position: center;
  }
  
  .content {
    width: 34%;
    padding: 2%;
    padding-top: 5%;
    padding-bottom: 0;
    padding-right: 8%;
    height: 40%;
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
  
  .btn > a {
    color: #fff;
  }
  
  /* .b {
      text-align: center;
  } */
  
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