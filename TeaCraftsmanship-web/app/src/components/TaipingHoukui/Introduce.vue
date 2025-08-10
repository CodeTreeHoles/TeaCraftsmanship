<template>
  <div id="introduce">
    <div class="introduce">
      <div class="name">
        <div class="img">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%A4%AA%E5%B9%B3%E7%8C%B4%E9%AD%81/%E8%8C%B6%E5%86%9C.jpg" alt="" />
        </div>
        <div class="t">
          <span>
            {{ stepText[8] }}
          </span>
        </div>
      </div>
      <div class="name">
        <div class="img1">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%A4%AA%E5%B9%B3%E7%8C%B4%E9%AD%81/Snipaste_2024-04-22_21-03-21.jpg" alt="" />
        </div>
        <div class="t2">
          <span>
            {{ stepText[9] }}
          </span>
        </div>
      </div>
      <div class="teacup">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%A4%AA%E5%B9%B3%E7%8C%B4%E9%AD%81/%E8%8C%B6%E6%9D%AF.jpg" alt="" />
      </div>
      <div class="effect">
        <div class="effect-title">
          <span> {{ stepText[10] }}</span>
        </div>
        <div class="effect-span">
          <span> {{ stepText[11] }}</span>
          <span> {{ stepText[12] }}</span>
        </div>
      </div>
      <div class="effect">
        <div class="effect-title1">
          <span> {{ stepText[13] }}</span>
        </div>
        <div class="effect-img">
          <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%A4%AA%E5%B9%B3%E7%8C%B4%E9%AD%81/7cdd212f35704bd8a8a78463ec878d8d.jpg" alt="" />
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

#introduce {
  margin-left: 10%;
  margin-right: 10%;
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

  .name .span {
    font-size: 17px !important;
  }

  .name .span1 {
    font-size: 17px !important;
  }

  .teacup img {
    margin-top: 28% !important;
  }

  .effect-title,
  .effect-title1 {
    text-align: center;
  }

  .effect-title span,
  .effect-title1 span {
    font-size: 30px !important;
  }

  .effect-span {
    margin-top: 6% !important;
    height: 58%;
  }

  .effect-span span {
    font-size: 20px !important;
  }

  .effect-img {
    margin-top: 5% !important;
  }
}

.introduce {
  display: flex;
}

.introduce>div {
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
  aspect-ratio: 1/1;
  /* 设置宽高比为1:1 */
  transform: translateY(50%);
}

.name .t {
  /* height: 20em; */
  font-size: 12px;
  padding: 1em;
  padding-top: 5em;
  text-indent: 2em;
  background: rgb(115, 137, 84);
}

.name .img1 {
  text-align: center;
}

.name .img1 img {
  border-radius: 50%;
  height: 8em;
  aspect-ratio: 1/1;
  /* 设置宽高比为1:1 */
  transform: translateY(50%);
}

.name .t2 {
  /* height: 20em; */
  font-size: 12px;
  padding: 1em;
  text-indent: 2em;
  padding-top: 5em;
  background: rgb(55, 77, 36);
}

.teacup {
  flex: 14%;
}

.teacup img {
  width: 100%;
  height: 76%;
  margin-top: 33%;
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
  background: rgb(229, 221, 199);
  box-shadow: 0px 0px 5px #0005;
  min-height: 60%;
  padding: 0.5em;
  color: #000a;
  text-indent: 2em;
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
  height: 100%;
}

@media screen and (max-width: 500px) {
  .introduce {
    display: block;
    height: auto;
    /* min-height: 170vh; */
  }

  .teacup {
    display: none;
  }
}
</style>