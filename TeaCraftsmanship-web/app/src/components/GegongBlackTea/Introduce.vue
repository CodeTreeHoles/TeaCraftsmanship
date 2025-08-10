<template>
  <div id="introduce">
    <div class="introduce">
      <div class="name">
        <div class="img">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E8%91%9B%E5%85%AC%E7%BA%A2%E8%8C%B6/Snipaste_2024-04-26_15-09-11.jpg" alt="" />
        </div>
        <div class="span">
          <p>{{ stepText[5] }} </p>
          <p>{{ stepText[6] }}</p>
        </div>
      </div>
      <div class="name">
        <div class="img1">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E8%91%9B%E5%85%AC%E7%BA%A2%E8%8C%B6/Snipaste_2024-04-26_15-08-41.jpg" alt="" />
        </div>
        <div class="span1">
          <span>
            {{ stepText[7] }}
          </span>
        </div>
      </div>
      <div class="teacup">
        <div>
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E8%91%9B%E5%85%AC%E7%BA%A2%E8%8C%B6/%E6%B3%A1%E8%8C%B6%E5%9B%BE.jpg" alt="" />
        </div>
        <span>{{ stepText[8] }}</span>
      </div>
      <div class="effect">
        <div class="effect-title">
          <span> {{ stepText[9] }}</span>
        </div>
        <div class="effect-span">
          <span>
            {{ stepText[10] }}</span
          >
          <span>
            {{ stepText[11] }}</span
          >
        </div>
      </div>
      <div class="effect">
        <div class="effect-title1"><span>{{ stepText[12] }}</span></div>
        <div class="effect-img">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E8%91%9B%E5%85%AC%E7%BA%A2%E8%8C%B6/%E5%8F%B3%E4%B8%8B%E8%A7%92.jpg" alt="" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "Introduce",
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
#introduce {
  margin-left: 10%;
  margin-right: 10%;
}
.introduce {
  display: flex;
}
.introduce > div {
  margin: 0 1%;
}
.name {
  flex: 15%;
  transform: translateY(-4em);
}
.name .img {
  text-align: center;
}
.name .img img {
  border-radius: 50%;
  height: 8em;
  aspect-ratio: 1/1; /* 设置宽高比为1:1 */
  transform: translateY(50%);
}
.name .span {
  min-height: 20em;
  font-size: 12px;
  padding: 0.5em;
  padding-top: 5em;
  background: rgb(115, 137, 84);
}
.name .span,
.name .span1{
  text-indent: 2em;
}
.name .img1 {
  text-align: center;
}
.name .img1 img {
  border-radius: 50%;
  height: 8em;
  aspect-ratio: 1/1; /* 设置宽高比为1:1 */
  transform: translateY(50%);
}
.name>.span1 {
  min-height: 20em;
  /* font-size: 12px; */
  font-size: 12px;
  padding: 0.5em;
  padding-top: 5em;
  background: rgb(55, 77, 36);
}
.teacup {
  flex: 14%;
}
.teacup img {
  width: 100%;
  height: 80%;
  margin-top: 33%;
}
span {
  font-size: 13px;
}
p{
  font-size: 13px;
}
.effect {
  flex: 18%;
}
.effect-title {
  margin-top: 22%;
}
.effect-title span {
  font-size: 19px;
}
.effect-span {
  margin-top: 10%;
  box-shadow: 0px 0px 5px #0005;
  background: rgb(229, 221, 199);
  padding: 5%;
}
.effect-title1 {
  margin-top: 22%;
}
.effect-title1 span {
  font-size: 18px;
}
.effect-img {
  height: 67%;
  margin-top: 10%;
}
.effect-img img {
  width: 100%;
  height: 80%;
}
@media screen and (max-width: 2000px) {
  .introduce {
    height: 50vh;
  }
}
@media screen and (min-width: 2000px) {
  .introduce {
    height: 30vh;
  }
  .teacup img {
    margin-top: 28%;
  }
  .effect-title span,
  .effect-title1 span {
    font-size: 30px;
  }
  .effect-span {
    margin-top: 6%;
    height: 58%;
  }
  .effect-span span {
    font-size: 20px;
  }
}
@media screen and (max-width: 500px) {
  .introduce {
    display: block;
    height: 170vh;
  }
  .introduce {
    height: auto;
  }
  .teacup {
    display: none;
  }
}
</style>