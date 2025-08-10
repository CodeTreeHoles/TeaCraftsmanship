<template>
    <div id="JinShanRain">
      <background></background>
      <Introduce></Introduce>
      <Step></Step>
    </div>
  </template>
  
  <script>
    import background from "../JinShanRain/background.vue";
    import Introduce from "../JinShanRain/Introduce.vue";
  import Step from "../JinShanRain/Step.vue";
  export default {
    name: "JinShanRain",
    components: {
      background,
      Introduce,
      Step
    },
  };
  </script>
  
  <style scoped>
#JinShanRain {
  background-color: rgb(228, 230, 216);
  min-height: 100vh;
}
@media screen and (max-width: 2000px) {
  #JinShanRain {
    padding-bottom: 1%;
  }
}
@media screen and (max-width: 500px) {
  #JinShanRain {
    height: auto;
  }
}
  </style>
  