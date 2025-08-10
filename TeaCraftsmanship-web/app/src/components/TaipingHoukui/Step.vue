<template>
  <div id="step">
    <div class="step">
      <div class="img">
        <div><img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%A4%AA%E5%B9%B3%E7%8C%B4%E9%AD%81/%E6%8B%A3%E5%B0%96.jpg" alt="" /></div>
        <span>{{ stepText[0] }}</span>
      </div>
      <div class="img">
        <div><img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%A4%AA%E5%B9%B3%E7%8C%B4%E9%AD%81/%E6%91%8A%E6%94%BE.jpg" alt="" /></div>
        <span>{{ stepText[1] }}</span>
      </div>
      <div class="img" id="img1">
        <div><img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%A4%AA%E5%B9%B3%E7%8C%B4%E9%AD%81/%E6%9D%80%E9%9D%92.jpg" alt="" /></div>
        <span>{{ stepText[2] }}</span>
      </div>
      <div class="img">
        <div><img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%A4%AA%E5%B9%B3%E7%8C%B4%E9%AD%81/%E7%83%98%E5%9F%B9.jpg" alt="" /></div>
        <span>{{ stepText[3] }}</span>
      </div>
      <div class="img">
        <div id="s">
          <p>{{ stepText[4] }}</p>
          <p>{{ stepText[5] }}</p>
          <p>{{ stepText[6] }}</p>
        </div>
        <span>{{ stepText[7] }}</span>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "Step",
  mounted() {
    this.$store.dispatch("TaipingStepList");
  },
  computed: {
    ...mapState({
      TaipingStepList: (state) => state.TaipingStep.TaipingStepList,
    }),
    stepText() {
      if (this.TaipingStepList && this.TaipingStepList.data) {
        return this.TaipingStepList.data;
      }
      return "";
    },
  },
};
</script>

<style scoped>
span {
  font-size: 14px;
}
p{
  font-size: 14px;
}
#step {
  margin-left: 10%;
  margin-right: 10%;
}

@media screen and (max-width: 2000px) {
  .step {
    height: 45vh;
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

#s {
  box-shadow: 0px 0px 5px #0005;
  padding: 0.5em;
  color: #000a;
  text-indent: 2em;
  background: rgb(229, 221, 199);
}

@media screen and (max-width:500px) {
  .step {
    display: block;
    height: auto;
  }

}
</style>