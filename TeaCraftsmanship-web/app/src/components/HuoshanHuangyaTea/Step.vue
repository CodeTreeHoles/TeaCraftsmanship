`<template>
  <div id="step">
    <div class="step">
      <div class="leaf">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%BB%84%E5%B1%B1%E6%AF%9B%E5%B3%B0/%E4%BE%A7%E8%BE%B9%E5%B7%A6.png" alt="" />
      </div>
      <div class="circle">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%9C%8D%E5%B1%B1%E9%BB%84%E8%8A%BD/%E6%9D%80%E9%9D%92.jpg" alt="" /><br />
        <h3>杀青</h3>
        <span>
          {{ stepText[4] }}
        </span>
      </div>
      <div class="circle">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%9C%8D%E5%B1%B1%E9%BB%84%E8%8A%BD/%E6%AF%9B%E7%81%AB.jpg" alt="" /><br />
        <h3>毛火</h3>
        <span>
          {{ stepText[5] }}
        </span>
      </div>
      <div class="circle">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%9C%8D%E5%B1%B1%E9%BB%84%E8%8A%BD/%E7%84%96%E9%BB%84.jpg" alt="" /><br />
        <h3>焖黄</h3>
        <span>
          {{ stepText[6] }}</span>
      </div>
      <div class="circle">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%9C%8D%E5%B1%B1%E9%BB%84%E8%8A%BD/%E8%B6%B3%E7%81%AB.jpg" alt="" /><br />
        <h3>足火</h3>
        <span>
          {{ stepText[7] }}</span>
      </div>
      <div class="circle" id="TJ">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%9C%8D%E5%B1%B1%E9%BB%84%E8%8A%BD/%E6%8B%A3%E5%89%94.jpg" alt="" /><br />
        <h3>拣剔</h3>
        <span>
          {{ stepText[8] }}</span>
      </div>
      <div class="leaf">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%BB%84%E5%B1%B1%E6%AF%9B%E5%B3%B0/%E4%BE%A7%E8%BE%B9%E5%8F%B3.png" alt="" />
      </div>
    </div>
    <hr />
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "Step",
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
#step {
  margin-left: 10%;
  margin-right: 10%;
}
h3{
  text-align: center;
}
.step {
  display: flex;
  /* text-align: center; */
  justify-content: center;
}

@media screen and (max-width: 2000px) {
  .step {
    height: 35vh;
    font-size: 13px;
  }

  .step .circle img {
    width: 100%;
    border-radius: 50%;
    aspect-ratio: 1 / 1;
  }
}

@media screen and (min-width: 2000px) {
  .step {
    height: 24vh;
    font-size: 17px;
  }

  .step .circle img {
    width: 80%;
    height: 65%;
    border-radius: 50%;
  }
}

.step .leaf {
  width: 15%;
  display: flex;
  align-items: center;
}

.step .leaf img {
  width: 100%;
  height: 50%;
}

.step .circle {
  width: 14%;
}

.circle {
  margin-right: 1%;
}

#TJ {
  margin-right: 0px;
}

hr {
  border: 3px solid black;
  margin-top: 2%;
  margin-bottom: 1%;
  margin-left: 2%;
  margin-right: 2%;
}

@media screen and (max-width: 500px) {
  .step {
    display: block;
    height: 100%;
  }
  .step>div{
    width: 50%;
  }

  .leaf img,
  hr {
    display: none;
  }

  .step .circle {
    width: 100%;
    text-align: center;
}
  .step .circle img {
    width: 70%;
  }
}
</style>`