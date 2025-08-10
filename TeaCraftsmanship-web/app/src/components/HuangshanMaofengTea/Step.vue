<template>
  <div id="step">
    <div class="step">
      <div class="leaf">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%BB%84%E5%B1%B1%E6%AF%9B%E5%B3%B0/%E4%BE%A7%E8%BE%B9%E5%B7%A6.png" alt="" />
      </div>
      <div class="circle">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%BB%84%E5%B1%B1%E6%AF%9B%E5%B3%B0/%E8%90%8E%E5%87%8B.jpg" alt="" /><br />
        <h3>萎凋</h3>
        <span>
          {{ getStepData(0) }}
        </span>
      </div>
      <div class="circle">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%BB%84%E5%B1%B1%E6%AF%9B%E5%B3%B0/%E6%9D%80%E9%9D%92.jpg" alt="" /><br />
        <h3>杀青</h3>
        <span>
          {{ getStepData(1) }}
        </span>
      </div>
      <div class="circle">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%BB%84%E5%B1%B1%E6%AF%9B%E5%B3%B0/%E6%8F%89%E6%8D%BB.jpg" alt="" /><br />
        <h3>揉捻</h3>
        <span>{{ getStepData(2) }}</span>
      </div>
      <div class="circle">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%BB%84%E5%B1%B1%E6%AF%9B%E5%B3%B0/%E7%83%98%E5%B9%B2.jpg" alt="" /><br />
        <h3>烘干</h3>
        <span>{{ getStepData(3) }}</span>
      </div>
      <div class="circle" id="TJ">
        <img src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%BB%84%E5%B1%B1%E6%AF%9B%E5%B3%B0/%E6%8B%A3%E5%89%94.jpg" alt="" /><br />
        <h3>拣剔</h3>
        <span>{{ getStepData(4) }}</span>
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
    this.$store.dispatch("HuangShanStepList");
  },
  computed: {
    ...mapState({
      HuangShanStepList: (state) => state.HuangShanStep.HuangShanStepList,
    }),
    getStepData() {
      return (index) => {
        if (this.HuangShanStepList && this.HuangShanStepList.data) {
          return this.HuangShanStepList.data[index] || "";
        } else {
          return "";
        }
      };
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
span{
  text-indent: 2em;
}

@media screen and (max-width: 2000px) {
  .step {
    height: 35vh;
    font-size: 13px;
  }

  .step .circle img {
    width: 100%;
    height: 56%;
    border-radius: 50%;
  }
}

@media screen and (min-width: 2000px) {
  .step {
    height: 24vh;
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

  .leaf img,
  hr {
    display: none;
  }

  .step .circle {
    width: 100%
  }

  .step .circle img {
    width: 100%;
    height: 100%;
    aspect-ratio: 1 / 1;

    /* border-radius: 0 !important; */
  }
}
</style>