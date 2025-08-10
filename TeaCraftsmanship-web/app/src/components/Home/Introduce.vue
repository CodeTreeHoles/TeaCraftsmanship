<template>
  <div>
    <div id="main">
      <h1>{{ currentContent.title }}</h1>
      <h2>{{ currentContent.place }}</h2>
      <p>{{ currentContent.text }}</p>
    </div>
  </div>
</template>

<script>
import {mapState} from 'vuex';
export default {
  data() {
    return {
    };
  },
      props: {
        inputName: Number,
        required: true
    },
  mounted() {
    this.$store.dispatch('homeList')
  },
  computed:{
    ...mapState({
      homeList:(state) => state.home.homeList
    }),
    currentContent() {
      if (this.homeList && this.homeList.data) {
        return this.homeList.data[this.inputName - 1] || {};
      }
      return {};
    }
  }
};
</script>


<style scoped>
div {
  color: #d4b98f;
  /* color: #7FA38B; */
    /* color: #163029; */
  /* box-shadow: 0px 0px 3px white; */
}

#main {
  height: 32vw;
  width: 100%;
  display: flex;
  font-family: "Ma+Shan+Zheng",cursive;
  font-size: 18px;
}

h1 {
  /* text-align: center; */
  width: 1em;
}
h2{
  width: 1em;
}

p {
  word-break: break-all;
  word-wrap: break-word;
  /* text-indent: 2em; */
  font-size: 20px;
  writing-mode:vertical-lr;
  /* width: 1em; */
}
@media screen and (min-device-width: 2000px) {
  #main{
    font-size: 25px;
  }
  p{
    font-size: 25px;
  }
}
@media screen and (max-device-width: 800px) {
  #main {
    height: 43vh;
  }
  p {
    line-height: 1.4em;
    margin: 5px;
  }
  h1 {
    line-height: 1.2em;
  }
  h2 {
    line-height: 1.2em;
  }
}
</style>