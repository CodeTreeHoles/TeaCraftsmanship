<template>
  <div id="step">
    <div class="step">
      <div class="img">
        <div><img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E8%91%9B%E5%85%AC%E7%BA%A2%E8%8C%B6/%E9%87%87%E6%91%98.jpg" alt="" /></div>
        <h4>鲜叶采摘与分级</h4>
        <span>{{ stepText[0] }}</span>
      </div>
      <div class="img">
        <div><img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E8%91%9B%E5%85%AC%E7%BA%A2%E8%8C%B6/%E8%90%8E%E5%87%8B.jpg" alt="" /></div>
        <h4>萎凋</h4>
        <span>{{ stepText[1] }}</span>
      </div>
      <div class="img">
        <div><img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E8%91%9B%E5%85%AC%E7%BA%A2%E8%8C%B6/%E6%8F%89%E6%8D%BB.jpg" alt="" /></div>
        <h4>揉捻</h4>
        <span>{{ stepText[2] }}</span>
      </div>
      <div class="img">
        <div><img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E8%91%9B%E5%85%AC%E7%BA%A2%E8%8C%B6/%E5%8F%91%E9%85%B5.jpg" alt="" /></div>
        <h4>发酵</h4>
        <span>{{ stepText[3] }}</span>
      </div>
      <div class="img">
        <div><img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E8%91%9B%E5%85%AC%E7%BA%A2%E8%8C%B6/%E5%88%86%E7%BA%A7%E8%A3%85%E7%AE%B1.jpg" alt="" /></div>
        <h4>干燥与分级装箱</h4>
        <span>{{ stepText[4] }}</span>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
  name: "Step",
  mounted() {
    this.$store.dispatch("GegongStepList");
  },
  computed: {
    ...mapState({
      GegongStepList: (state) => state.GegongStep.GegongStepList,
    }),
    stepText() {
      if (this.GegongStepList && this.GegongStepList.data) {
        return this.GegongStepList.data;
      }
      return "";
    },
  },
};
</script>

<style scoped>
span{
  font-size: 14px;
  text-indent: 2em;
}
h4 {
  text-align: center;
}
#step {
  margin-left: 10%;
  margin-right: 10%;
}
@media screen and (max-width: 2000px) {
  .step {
    height: 42vh;
  }
}
@media screen and (min-width: 2000px) {
  .step {
    height: 30vh;
  }
  span {
    font-size: 17px !important;
  }
  #span {
    margin-top: 12% !important;
  }
}
.step {
  display: flex;
  margin-top: 2%;
  text-align: center;
}
.step .img {
  flex: 1;
  margin-left: 1%;
  margin-right: 1%;
}

.step .img div {
  height: 70%;
  margin-bottom: 5%;
}
.step .img div img {
  height: 100%;
  width: 100%;
}
#span {
  height: 70%;
  height: 60%;
  margin-top: 15%;
  background: rgb(229, 221, 199);
}
span {
  display: inline-block;
  text-align: left;
  font-size: 12px;
}
@media screen and (max-width: 500px) {
  .step {
    display: block;
    height: auto;
  }
  #span {
    /* margin-top: 2% !important; */
    /* background-color: transparent; */
  }
}
</style>