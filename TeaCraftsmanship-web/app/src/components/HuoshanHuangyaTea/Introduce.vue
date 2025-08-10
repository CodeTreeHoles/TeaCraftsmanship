<template>
  <div id="introduce">
    <div class="introduce">
      <div class="HuangShan-img">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%9C%8D%E5%B1%B1%E9%BB%84%E8%8A%BD/%E5%A4%A7%E5%9B%BE.jpg" alt="" />
      </div>
      <div class="origin">
        <div class="maofeng-img1">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%9C%8D%E5%B1%B1%E9%BB%84%E8%8A%BD/1.jpg" alt="" />
          <div>
            <h3>霍山黄芽</h3>
            <h4>——传承古老茶艺</h4>
            <span>{{ stepText[0] }}</span>
          </div>

        </div>
        <div class="maofeng-img2">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%9C%8D%E5%B1%B1%E9%BB%84%E8%8A%BD/3.jpg" alt="" /><br />
          <p>{{ stepText[1] }}</p>
        </div>
        <div class="maofeng-img1">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%9C%8D%E5%B1%B1%E9%BB%84%E8%8A%BD/2.jpg" alt="" />
          <div>
            <h3>霍山黄芽</h3>
          <h4>——烘青绿茶中的佼佼者</h4>
          <span>{{ stepText[2] }}</span>
          </div>
        </div>
        <div class="maofeng-img2">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%9C%8D%E5%B1%B1%E9%BB%84%E8%8A%BD/4.jpg" alt="" />
          <p>{{ stepText[3] }}</p>
        </div>
      </div>
    </div>
    <hr />
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "Introduce",
  mounted() {
    this.$store.dispatch("HuoShanStepList");
  },
  computed: {
    ...mapState({
      HuoShanStepList: (state) =>
        state.HuoShanStep.HuoShanStepList,
    }),
    stepText() {
      if (this.HuoShanStepList && this.HuoShanStepList.data) {
        return this.HuoShanStepList.data;
      }
      return "";
    },
  },
};
</script>

<style scoped>
#introduce {
  margin-left: 10%;
  margin-right: 10%;
}

.introduce {
  display: flex;
}

h3 {
  text-align: center;
}

h4 {
  text-align: right;
}

span {
  font-size: 14px;
  text-indent: 2em;
}

.introduce .HuangShan-img,
.introduce .origin {
  flex: 1;
}

.HuangShan-img {
  margin: 1em;
  margin-left: 0px;
}
.maofeng-img1>div{
  margin-left: 0.5em;
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

.maofeng-img1{
  width: 62%;
  margin-right: 5%;
  margin-top: 2%;
  display: flex;
}

.maofeng-img1 img{
  width: 50%;
  box-sizing: border-box;
}

.maofeng-img1 span{
  display: flex;
  /* text-align: center; */
  margin-left: 2%;
}

.maofeng-img2{
  width: 28%;
  margin-right: 5%;
  margin-top: 2%;
  font-size: 14px;
}

.maofeng-img2 img{
  width: 100%;
  height: 70%;
}

.maofeng-img1,
.maofeng-img2 {
  margin-bottom: 2%;
}


.maofeng-img2>p{
  text-indent: 2em;
}

hr {
  border: 3px solid black;
  margin-top: 1%;
  margin-bottom: 1%;
  margin-left: 4%;
  margin-right: 4%;
}
@media screen and (max-width: 2000px) {
  .introduce {
    height: 60vh;
  }

  .maofeng-img1{
    height: 27vh;
    font-size: 13px;
  }

  .maofeng-img2 span{
    font-size: 13px;
  }
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
  .origin{
    display: block;
    height: auto;
  }

  .maofeng-img1,
  .maofeng-img2{
    display: block;
    height: auto;
    width: 100%;
    align-items: center;
    /* margin-right: 0% !important; */
  }

  .maofeng-img1 img,
  .maofeng-img2 img{
    width: 100%;
  }
}


@media screen and (min-width: 2000px) {
  .introduce {
    height: 43vh;
  }

  .maofeng-img1 {
    height: 19vh;
    font-size: 17px;
  }
  .maofeng-img2 span{
    font-size: 17px;
  }
}
</style>