<template>
  <div id="step">
    <div class="technology-two">
      <div class="step">
        <div class="img">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%87%91%E5%B1%B1%E6%97%B6%E9%9B%A8/%E6%8F%89%E6%8D%BB.jpg" alt="" />
          <div class="span">
            <span> {{ stepText[4] }}</span>
          </div>
        </div>
      </div>
      <div class="step">
        <div class="img">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%87%91%E5%B1%B1%E6%97%B6%E9%9B%A8/%E5%81%9A%E8%83%9A.jpg" alt="" />
          <div class="span">
            <span> {{ stepText[5] }}</span>
          </div>
        </div>
      </div>
      <div class="step">
        <div class="img">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%87%91%E5%B1%B1%E6%97%B6%E9%9B%A8/%E6%91%8A%E5%87%89.jpg" alt="" />
          <div class="span">
            <span> {{ stepText[6] }}</span>
          </div>
        </div>
      </div>
      <div class="step">
        <div class="img">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%87%91%E5%B1%B1%E6%97%B6%E9%9B%A8/%E5%81%9A%E5%BD%A2.jpg" alt="" />
          <div class="span">
            <span> {{ stepText[7] }}</span>
          </div>
        </div>
      </div>
      <div class="step">
        <div class="img">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%87%91%E5%B1%B1%E6%97%B6%E9%9B%A8/%E8%B6%B3%E7%81%AB.jpg" alt="" />
          <div class="span">
            <span> {{ stepText[8] }}</span>
          </div>
        </div>
      </div>
      <div class="step">
        <div class="img">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%87%91%E5%B1%B1%E6%97%B6%E9%9B%A8/%E5%8F%B3%E4%B8%8B%E8%A7%92%E5%B0%8F%E5%9B%BE.jpg" alt="" />
          <div class="span">
            <span> {{ stepText[9] }}</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
  
  <script>
import { mapState } from "vuex";
export default {
  name: "Step",
  mounted() {
    this.$store.dispatch("JinShanStepList");
  },
  computed: {
    ...mapState({
      JinShanStepList: (state) => state.JinShaStep.JinShanStepList,
    }),
    stepText() {
      if (this.JinShanStepList && this.JinShanStepList.data) {
        return this.JinShanStepList.data;
      }
      return "";
    },
  },
};
</script>
  
  <style scoped>
  span{
    font-size: 13px;
  }
#step {
  margin-left: 10%;
  margin-right: 10%;
}
#black {
  background-color: rgb(46, 45, 50);
  color: white;
}
.technology-two {
  display: flex;
  margin: 0px 4%;
  margin-top: 3%;
}
  .technology-two {
    min-height: 30vh;
  }
.step {
  flex: 1;
  margin: 1%;
}
.step .img {
  height: 60%;
  width: 100%;
}
.step .img img {
  width: 100%;
  height: 100%;
}
@media screen and (max-width: 500px) {
  .technology-two {
  display: block;
}
}
</style>
  