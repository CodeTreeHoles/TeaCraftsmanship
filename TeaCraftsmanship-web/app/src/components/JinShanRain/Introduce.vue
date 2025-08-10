<template>
  <div id="introduce">
    <div class="technology-one">
      <div class="brew">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%87%91%E5%B1%B1%E6%97%B6%E9%9B%A8/1.jpg" alt="" />
      </div>
      <div class="histor">
        <div class="background"><img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%87%91%E5%B1%B1%E6%97%B6%E9%9B%A8/2.jpg" alt="" /></div>
        <div class="introduce">
          {{ stepText[0] }}
        </div>
      </div>
      <div class="make">
        <div class="background"><img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%87%91%E5%B1%B1%E6%97%B6%E9%9B%A8/%E9%87%87%E6%91%98.jpg" alt="" /></div>
        <div class="introduce">
          {{ stepText[1] }}
        </div>
      </div>
      <div class="PrimaryProcessing">
        <div class="background"><img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%87%91%E5%B1%B1%E6%97%B6%E9%9B%A8/%E6%91%8A%E6%94%BE.jpg" alt="" /></div>
        <div class="introduce">
          {{ stepText[2] }}
        </div>
      </div>
      <div class="knead">
        <div class="background">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%87%91%E5%B1%B1%E6%97%B6%E9%9B%A8/%E6%9D%80%E9%9D%92.jpg" alt="" />
        </div>
        <div class="introduce">
          {{ stepText[3] }}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
  name: "Introduce",
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
div{
  font-size: 13px;
}
#introduce {
  margin-left: 10%;
  margin-right: 10%;
}
.technology-one {
  display: flex;
  margin: 0px 4%;
  margin-top: 2%;
}
@media screen and (max-width: 2000px) {
  .technology-one {
    height: 42vh;
  }
}
@media screen and (min-width: 2000px) {
  .technology-one {
    height: 35vh;
  }
}
.technology-one > div {
  flex: 1;
  margin: 0 1%;
}
img {
  width: 100%;
  height: 100%;
}
.technology-one .histor,
.technology-one .make,
.technology-one .PrimaryProcessing,
.technology-one .knead {
  margin-top: 2%;
  position: relative;
}

.technology-one .histor .background,
.technology-one .make .background,
.technology-one .PrimaryProcessing .background,
.technology-one .knead .background {
  position: absolute;
  width: 100%;
  height: 50%;
}
.technology-one .introduce {
  position: absolute;
  width: calc(100% - 1em);
  height: 40%;
  box-shadow: 0px 0px 5px #0008;
  padding: 0.5em;
  margin-top: 1.5em;
  text-indent: 2em;
  top: 50%;
  display: flex;
  align-items: center;
}
.technology-one .PrimaryProcessing .background,
.technology-one .make .background,
.technology-one .knead .background {
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
}
.technology-one .histor .background img {
  width: 100%;
  height: 100%;
}
@media screen and (max-width: 500px) {
  .brew{
    display: none;
  }
  .technology-one{
    display: block;
    height: auto;
    margin-top: 0%;
  }
  .introduce{
    min-height: 6em;
  }
  .technology-one>div{
    height: 25em;
  }
  .technology-one .introduce {
    /* margin-bottom: 1.5em; */
    height: auto;
  }
}
</style>