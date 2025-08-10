<template>
  <div id="step">
    <div class="step">
      <div class="picture">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%B2%B3%E8%A5%BF%E7%BF%A0%E5%85%B0/%E6%91%8A%E5%87%89.jpg" alt="" />
        <div class="description">
          <h3>摊放</h3>
          <span>{{ stepText[4] }}</span>
        </div>
      </div>
      <div class="picture">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%B2%B3%E8%A5%BF%E7%BF%A0%E5%85%B0/%E6%9D%80%E9%9D%92.jpg" alt="" />
        <div class="description">
          <h3>杀青</h3>
          <span>{{ stepText[5] }}</span>
        </div>
      </div>
      <div class="picture">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%B2%B3%E8%A5%BF%E7%BF%A0%E5%85%B0/%E7%90%86%E6%9D%A1.jpg" alt="" />
        <div class="description">
          <h3>理条</h3>
          <span>{{ stepText[6] }}</span>
        </div>
      </div>
      <div class="picture">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%B2%B3%E8%A5%BF%E7%BF%A0%E5%85%B0/%E6%9D%80%E9%9D%92.jpg" alt="" />
        <div class="description">
          <h3>毛火</h3>
          <span>{{ stepText[7] }}</span>
        </div>
      </div>
      <div class="picture">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%B2%B3%E8%A5%BF%E7%BF%A0%E5%85%B0/%E6%91%8A%E5%87%89.jpg" alt="" />
        <div class="description">
          <h3>摊凉</h3>
          <span>{{ stepText[8] }}</span>
        </div>
      </div>
      <div class="picture">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%B2%B3%E8%A5%BF%E7%BF%A0%E5%85%B0/%E8%B6%B3%E7%81%AB.jpg" alt="" />
        <div class="description">
          <h3>足火</h3>
          <span>{{ stepText[9] }}</span>
        </div>
      </div>
    </div>
  </div>
</template>
  
  <script>
  import { mapState } from 'vuex';
export default {
  name: "Content",
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
  font-size: 13px;
}

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
}

.description {
  margin-top: 10px;
  font-size: 13px;
}
.description span:first-child{
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
  