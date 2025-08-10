<template>
  <div id="introduce">
    <div class="introduce">
      <div class="HuangShan-img">
        <div alt="">
          <h1>毛峰传奇</h1>
          <span>
            光绪年间，漕溪人谢氏在上海漕溪路开设茶行，为提高市场竞争力，谢氏寻访高山好茶，在漕溪充川一带采摘肥壮的嫩芽、嫩叶，以手工精细炒制，很受欢迎。茶近黄色如象牙，鲜叶又采自黄山地带，干茶峰毫显露，故命名为“黄山毛峰”
          </span>
        </div>
      </div>
      <div class="origin">
        <div class="maofeng-img1">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%BB%84%E5%B1%B1%E6%AF%9B%E5%B3%B0/%E9%AB%98%E5%B1%B1%E8%8C%B6%E5%9B%AD.jpg" alt="" />
          <div>
            <h3>黄山毛峰</h3>
            <h4>——高山出名茶</h4>
            <span>{{ splittedArray[0] }}</span>
          </div>

        </div>
        <div class="maofeng-img2">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%BB%84%E5%B1%B1%E6%AF%9B%E5%B3%B0/%E9%87%87%E8%8C%B6-1.jpg" alt="" /><br />
          <span>{{ splittedArray[2] }}</span>
        </div>
        <div class="maofeng-img3">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%BB%84%E5%B1%B1%E6%AF%9B%E5%B3%B0/%E6%89%8B%E6%8D%A7%E8%8C%B6.jpg" alt="" />
          <div>
            <h3>黄山毛峰</h3>
            <h4>——烘青绿茶中的佼佼者</h4>
            <span>{{ splittedArray[1] }}</span>
          </div>
        </div>
        <div class="maofeng-img4">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%BB%84%E5%B1%B1%E6%AF%9B%E5%B3%B0/%E8%8C%B6%E5%8F%B6.jpg" alt="" />
          <span>{{ splittedArray[3] }}</span>
        </div>
      </div>
    </div>
    <hr />
  </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
  name: "Introduce",
  mounted() {
    this.$store.dispatch("HuangShanHistoryList");
  },
  computed: {
    ...mapState({
      HuangShanHistoryList: (state) =>
        state.HuangShanHistory.HuangShanHistoryList,
    }),
    splittedArray() {
      // 对历史数据进行分割
      if (this.HuangShanHistoryList.data) {
        return this.HuangShanHistoryList.data.history.split("\r\n");
      } else {
        return [];
      }
    },
  },
};
</script>

<style scoped>
#introduce {
  margin-left: 10%;
  margin-right: 10%;
}

h3 {
  text-align: center;

}

h4 {
  text-align: right;
}

span {
  font-size: 13px;
  text-indent: 2em;
}

.introduce {
  display: flex;
}

.introduce .HuangShan-img,
.introduce .origin {
  flex: 1;
}

.HuangShan-img {
  background: url("https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%BB%84%E5%B1%B1%E6%AF%9B%E5%B3%B0/%E6%AF%9B%E5%B3%B0%E5%9B%BE.jpg");
  background-size: 100% 100%;
  background-position: center;
  margin: 1em;
  margin-left: 0px;
  
}

.HuangShan-img>div{
  width: 50%;
  margin-left: 50%;
  /* font-size: 16px; */
  font-family: "Ma+Shan+Zheng",cursive;
  position: relative;
  top: 40%;
  /* margin-top: calc(100% - 50em); */
}
.HuangShan-img h1{
  text-align: center;
}
.HuangShan-img>div>span{
  font-size: 22px;
  text-indent: 2em;
}

@media screen and (max-width: 2000px) {
  .introduce {
    height: 60vh;
  }

  .maofeng-img1,
  .maofeng-img3 {
    height: 27vh;
    font-size: 13px;
  }
}

@media screen and (min-width: 2000px) {
  .introduce {
    height: 43vh;
  }

  .maofeng-img1,
  .maofeng-img3 {
    height: 19vh;
    font-size: 17px;
  }

}

.introduce .HuangShan-img img {
  width: 100%;
  height: 100%;
}

.origin {
  display: flex;
  flex-wrap: wrap;
}

.origin>div {
  box-sizing: border-box;
}

.maofeng-img1,
.maofeng-img3 {
  width: 62%;
  margin-right: 5%;
  margin-top: 2%;
  display: flex;
}

.maofeng-img1>div,
.maofeng-img3>div {
  padding-left: 1em;
}

.maofeng-img1 img,
.maofeng-img3 img {
  width: 50%;
  box-sizing: border-box;
}

.maofeng-img1 span,
.maofeng-img3 span {
  display: flex;
  /* text-align: center; */
  margin-left: 2%;
}

.maofeng-img2,
.maofeng-img4 {
  width: 28%;
  margin-right: 5%;
  margin-top: 2%;
  /* font-size: 11px; */
}

.maofeng-img2 img,
.maofeng-img4 img {
  width: 100%;
  height: 75%;
}

.maofeng-img3,
.maofeng-img4 {
  margin-bottom: 2%;
}

hr {
  border: 3px solid black;
  margin-top: 1%;
  margin-bottom: 1%;
  margin-left: 4%;
  margin-right: 4%;
}

@media screen and (max-width: 500px) {
  .introduce {
    height: auto;
    width: 100%;
  }

  .HuangShan-img,
  hr {
    display: none;
  }

  .maofeng-img1,
  .maofeng-img2,
  .maofeng-img3,
  .maofeng-img4 {
    display: block;
    height: auto;
    width: 100%;
    align-items: center;
    margin-right: 0% !important;
  }

  .maofeng-img1 img,
  .maofeng-img2 img,
  .maofeng-img3 img,
  .maofeng-img4 img {
    width: 100%;
  }
}
</style>