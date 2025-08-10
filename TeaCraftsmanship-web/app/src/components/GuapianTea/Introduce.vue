<template>
  <div id="introduce">
    <div class="history">
      <div class="introduce">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%85%AD%E5%AE%89%E7%93%9C%E7%89%87/%E9%9A%8F%E5%9B%AD%E9%A3%9F%E5%8D%95.jpg" alt="" />
        <span
          >{{ stepText[0] }}</span
        >
      </div>
      <div class="introduce" id="test">
        <img src="./images/.png" alt="" />
        <span>{{ stepText[1] }}</span>
      </div>
      <div class="introduce">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%85%AD%E5%AE%89%E7%93%9C%E7%89%87/57065175390c329726310caa5562659.jpg" alt="" />
        <span
          >{{ stepText[2] }}</span
        >
      </div>
      <div class="introduce">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%85%AD%E5%AE%89%E7%93%9C%E7%89%87/00055.jpg" alt="" />
        <span
          >{{ stepText[3] }}</span
        >
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
  name: "Introduce",
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
#introduce {
  margin-left: 10%;
  margin-right: 10%;
}
.history {
  display: flex;
  margin: 2%;
}
.history {
  min-height: 20vh;
}
@media screen and (max-width: 2000px) {
  .history {
    font-size: 15px;
  }
}
@media screen and (min-width: 2000px) {
  .history {
    font-size: 18px;
  }
}
.history .introduce {
  flex: 1;
  display: flex;
  align-items: center;
}
.history .introduce img,
.history .introduce span {
  width: 50%;
  aspect-ratio: 1 / 1; /* 设置宽高比为 1:1 */
}
.history .introduce img {
  /* height: 50%; */
  border-radius: 50%;
  margin-right: 5px;
}

@media screen and (max-width: 500px) {
  .history {
    display: block;
    margin: 2%;
  }
  .introduce {
    margin-top: 40px;
  }
  span {
    /* margin-top: 10px; */
    font-size: 11px;
  }
}
</style>