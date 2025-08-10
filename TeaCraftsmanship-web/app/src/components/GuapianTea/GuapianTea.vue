<template>
  <div id="GuapianTea">
    <background></background>
    <Introduce></Introduce>
    <Step></Step>
  </div>
</template>

<script>
import background from "../GuapianTea/background.vue";
import Introduce from "../GuapianTea/Introduce.vue";
import Step from "../GuapianTea/Step.vue";
export default {
  name: "GuapianTea",
  components: {
    background,
    Introduce,
    Step,
  },
};
</script>

<style scoped>
#GuapianTea {
  background-color: rgb(228, 230, 216);
  min-height: 100vh;
}
@media screen and (max-width: 2000px) {
  #GuapianTea {
    padding-bottom: 1%;
  }
}
@media screen and (max-width: 500px) {
  #GuapianTea {
    height: auto;
  }
}
</style>