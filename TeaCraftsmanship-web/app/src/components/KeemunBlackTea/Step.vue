<template>
  <div id="step">
    <div class="technology-two">
      <div class="fermentation" id="black">
        <h3>发酵</h3>
        <p>{{ stepText[6] }}</p>
      </div>
      <div class="drying">
        <h3>烘干</h3>
        <p>
          {{ stepText[7] }}
        </p>
      </div>
      <div class="screening">
        <h3>筛分</h3>
        <p>
          {{ stepText[8] }}
        </p>
      </div>
      <div class="sorting">
        <h3>拣剔</h3>
        <p>{{ stepText[9] }}</p>
        <h3>补火</h3>
        <p>{{ stepText[10] }}</p>
      </div>
      <div class="plug" id="">
        <h3>官堆</h3>
        <p>{{ stepText[11] }}</p>
      </div>
      <div class="img">
        <div>
          <img
            src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E7%A5%81%E9%97%A8%E7%BA%A2%E8%8C%B6/%E6%9C%AB%E5%B0%BE%E5%9B%BE.jpg"
            alt="" />
          <p>{{ stepText[12] }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "Step",
  mounted() {
    this.$store.dispatch("KeemunStepList");
  },
  computed: {
    ...mapState({
      KeemunStepList: (state) => state.KeemunStep.KeemunStepList,
    }),
    stepText() {
      if (this.KeemunStepList && this.KeemunStepList.data) {
        return this.KeemunStepList.data;
      }
      return "";
    },
  },
};
</script>

<style scoped>
.plug {
  box-shadow: 0px 0px 5px #0005;
}

.screening {
  box-shadow: 0px 0px 5px #0005;
}

span {
  font-size: 14px;
}

#step {
  margin-left: 10%;
  margin-right: 10%;
}

#black {
  background-color: rgb(46, 45, 50);
  color: white;
}

h3 {
  text-align: center;
}

.technology-two {
  display: flex;
  margin: 0px 4%;
  margin-top: 3%;
}

.technology-two>div>p {
  font-size: 14px;
  text-indent: 2em;
}

@media screen and (max-width: 2000px) {
  .technology-two {
    min-height: 23vh;
  }
}

@media screen and (min-width: 2000px) {
  .technology-two {
    height: 18vh;
  }
}

.technology-two>div {
  flex: 1;
  margin: 0 1%;
}

.technology-two .img img {
  width: 100%;
  height: 50%;
}

.technology-two .drying,
.technology-two .sorting {
  background-color: rgb(205, 204, 183);
}

@media screen and (max-width: 2000px) {

  .technology-two .plug,
  .technology-two .img {
    height: 28vh;
  }
}

@media screen and (max-width: 500px) {
  .technology-two {
    display: block;
  }
  #step>div>div{
    margin-top: 1em;
    padding: 0.5em;
  }
  .technology-two .plug,
  .technology-two .img {
    height: auto;
  }
}

@media screen and (min-width: 2000px) {
  #Introduce {
    height: 100vh;
  }
}
</style>