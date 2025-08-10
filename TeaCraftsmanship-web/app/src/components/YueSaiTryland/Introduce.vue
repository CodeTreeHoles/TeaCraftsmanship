<template>
  <div id="introduce">
    <div class="history">
      <div class="introduce">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%B2%B3%E8%A5%BF%E7%BF%A0%E5%85%B0/1.jpg" alt="" />
        <span
          >{{ stepText[0] }}</span
        >
      </div>
      <div class="introduce" id="test">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%B2%B3%E8%A5%BF%E7%BF%A0%E5%85%B0/2%20%282%29.jpg" alt="" />
        <span>{{ stepText[1] }}</span>
      </div>
      <div class="introduce">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%B2%B3%E8%A5%BF%E7%BF%A0%E5%85%B0/3.jpg" alt="" />
        <span
          >{{ stepText[2] }}</span>
      </div>
      <div class="introduce">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%B2%B3%E8%A5%BF%E7%BF%A0%E5%85%B0/00055.jpg" alt="" />
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
    this.$store.dispatch("YueXiStepList");
  },
  computed: {
    ...mapState({
      YueXiStepList: (state) => state.YueXiStep.YueXiStepList,
    }),
    stepText() {
      if (this.YueXiStepList && this.YueXiStepList.data) {
        return this.YueXiStepList.data;
      }
      return "";
    },
  },
};
</script>

<style scoped>
span{
  font-size: 14px;
}
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
  margin-right: 5px;
  border-radius: 50%;
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