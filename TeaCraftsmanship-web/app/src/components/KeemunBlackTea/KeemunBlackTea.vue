<template>
    <div id="KeemunBlackTea">
      <background></background>
      <Introduce></Introduce>
      <Step></Step>
    </div>
  </template>
  
  <script>
  import Step from "../KeemunBlackTea/Step.vue";
  import background from "../KeemunBlackTea/background.vue";
  import Introduce from "../KeemunBlackTea/Introduce.vue";
  export default {
    name: "KeemunBlackTea",
    components: {
      background,
      Introduce,
      Step
    },
  };
  </script>
  
  <style scoped>
  #KeemunBlackTea {
    background-color: rgb(228, 230, 216);
  }
  @media screen and (max-width: 2000px) {
    #KeemunBlackTea {
        height: 130vh;
    }
  }
  @media screen and (min-width: 2000px) {
    #KeemunBlackTea {
      height: 100vh;
    }
  }
  @media screen and (max-width: 500px) {
    #KeemunBlackTea {
      height: auto;
    }
  }
  </style>
  