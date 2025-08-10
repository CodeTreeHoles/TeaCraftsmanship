<template>
  <div id="introduce">
    <div class="technology-one">
      <div class="brew">
        <img
          src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E7%A5%81%E9%97%A8%E7%BA%A2%E8%8C%B6/%E6%B3%A1%E8%8C%B6.jpg"
          alt="" />
      </div>
      <div class="histor">
        <div class="background"><img
            src="https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E7%A5%81%E9%97%A8%E7%BA%A2%E8%8C%B6/%E6%89%8B%E6%8D%A7%E8%8C%B6.jpg"
            alt="" /></div>
        <div class="introduce">
          <div>
            {{ historyText }}
          </div>
        </div>
      </div>
      <div class="make">
        <div class="background" id="black">
          <div>{{ stepText[0] }}</div>
        </div>
        <div class="introduce">
          {{ stepText[1] }}
        </div>
      </div>
      <div class="PrimaryProcessing">
        <div class="background" id="red">
          <div>
            <h3>初制</h3>
            <span>{{ stepText[2] }}</span>
          </div>

        </div>
        <div class="introduce">
          {{ stepText[3] }}
        </div>
      </div>
      <div class="knead">
        <div class="background" id="red">
          <div>
            <h3>揉捻</h3>
            <span>{{ stepText[4] }}</span>
          </div>
        </div>
        <div class="introduce">
          {{ stepText[5] }}
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
    this.$store.dispatch("KeemunHistoryList");
    this.$store.dispatch("KeemunStepList");
  },
  computed: {
    ...mapState({
      KeemunHistoryList: (state) => state.KeemunHistory.KeemunHistoryList,
    }),
    historyText() {
      if (this.KeemunHistoryList && this.KeemunHistoryList.data) {
        return this.KeemunHistoryList.data.history;
      }
      return "";
    },
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
#introduce {
  margin-left: 10%;
  margin-right: 10%;
}

h3 {
  text-align: center;
}

.technology-one {
  display: flex;
  margin: 0px 4%;
  margin-top: 2%;
}

@media screen and (max-width: 2000px) {
  .technology-one {
    height: 40vh;
  }
}

@media screen and (min-width: 2000px) {
  .technology-one {
    height: 35vh;
  }
}

.technology-one>div {
  flex: 1;
  margin: 0 1%;
}

.technology-one .brew img {
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
  /* text-align: center; */
  position: absolute;
  width: 100%;
  height: 50%;
  top: 50%;
  display: flex;
  align-items: center;
}

/* .technology-one .PrimaryProcessing .background, */
/* .technology-one .make .background, */
/* .technology-one .knead .background>div { */
/* display: flex; */
/* justify-content: center;
  align-items: center; */
/* text-align: center; */
/* } */

.technology-one .histor .background img {
  width: 100%;
  height: 100%;
}

#black {
  background-color: rgb(46, 45, 50);
  color: white;
}

#red {
  background-color: rgb(130, 25, 38);
  color: white;
}


.background>div {
  padding: 1em;
}

@media screen and (max-width: 500px) {
  .brew {
    display: none;
  }

  .technology-one {
    display: block;
    height: auto;
  }

  .technology-one .histor .background,
  .technology-one .make .background,
  .technology-one .PrimaryProcessing .background,
  .technology-one .knead .background {
    height: 9em;
    position: static;
  }
  .technology-one .introduce {
    position: static;
  }
}
</style>