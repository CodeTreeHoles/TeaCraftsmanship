<template>
  <div id="step">
    <div class="step">
      <div class="picture">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%85%AD%E5%AE%89%E7%93%9C%E7%89%87/%E9%87%87%E6%91%98%E8%8C%B6%E5%8F%B6.jpg" alt="" />
        <div class="description">
          <h3>鲜叶采摘</h3>
          <span
            >{{ stepText[4] }}</span
          >
        </div>
      </div>
      <div class="picture">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%85%AD%E5%AE%89%E7%93%9C%E7%89%87/%E6%99%BE%E6%99%92.jpg" alt="" />
        <div class="description">
          <h3>晾晒</h3>
          <span>{{ stepText[5] }}</span>
        </div>
      </div>
      <div class="picture">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%85%AD%E5%AE%89%E7%93%9C%E7%89%87/%E6%8F%89%E6%8D%BB.jpg" alt="" />
        <div class="description">
          <h3>揉捻</h3>
          <span
            >{{ stepText[6] }}</span
          >
        </div>
      </div>
      <div class="picture">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%85%AD%E5%AE%89%E7%93%9C%E7%89%87/%E8%A7%A3%E5%9D%97.jpg" alt="" />
        <div class="description">
          <h3>解块</h3>
          <span>{{ stepText[7] }}</span>
        </div>
      </div>
      <div class="picture">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%85%AD%E5%AE%89%E7%93%9C%E7%89%87/%E7%82%92%E8%8C%B6%E5%8F%B6.jpg" alt="" />
        <div class="description">
          <h3>炒干</h3>
          <span
            >{{ stepText[8] }}</span
          >
        </div>
      </div>
      <div class="picture">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%85%AD%E5%AE%89%E7%93%9C%E7%89%87/%E7%83%98%E5%9F%B9.jpg" alt="" />
        <div class="description">
          <h3>烘焙</h3>
          <span
            >{{ stepText[9] }}</span
          >
        </div>
      </div>
    </div>
  </div>
</template>
  
  <script>
import { mapState } from "vuex";
export default {
  name: "Content",
  mounted() {
    this.$store.dispatch("GuaPianStepList");
  },
  computed: {
    ...mapState({
      GuaPianStepList: (state) => state.GuaPianStep.GuaPianStepList,
    }),
    stepText() {
      if (this.GuaPianStepList && this.GuaPianStepList.data) {
        return this.GuaPianStepList.data;
      }
      return "";
    },
  },
};
</script>
  
<style scoped>

h3 {
  text-align: center;
}
#step {
  margin-left: 10%;
  margin-right: 10%;
}

.step {
  display: flex;
  margin: 0px 10px;
}

.picture {
  flex: 1;
  margin: 0px 1%;
}

.picture img {
  width: 100%;
  height: 40%;
  box-shadow: 0px 0px 10px #0008;
}

.description {
  margin-top: 10px;
  font-size: 13px;
}
.description span:first-child {
  display: block;
  text-align: center;
}

@media screen and (max-width: 2000px) {
  .description {
    font-size: 15px;
  }
}

@media screen and (min-width: 2000px) {
  .description {
    font-size: 18px;
  }
}

@media screen and (max-width: 500px) {
  .step {
    display: block;
    margin: 2%;
  }

  .description {
    margin-bottom: 20px;
  }

  span {
    /* margin-top: 10px; */
    font-size: 11px;
  }
}
</style>
  