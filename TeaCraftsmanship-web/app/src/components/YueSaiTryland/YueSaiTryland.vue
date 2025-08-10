<template>
  <div id="YueSaiTryland">
    <background></background>
    <Introduce></Introduce>
    <Step></Step>
  </div>
</template>

<script>
import background from "../YueSaiTryland/background.vue";
import Introduce from "../YueSaiTryland/Introduce.vue";
import Step from "../YueSaiTryland/Step.vue";
export default {
  name: "YueSaiTryland",
  components: {
    background,
    Introduce,
    Step,
  },
};
</script>

<style scoped>
#YueSaiTryland {
  background-color: rgb(228, 230, 216);
  min-height: 100vh;
}
@media screen and (max-width: 2000px) {
  #YueSaiTryland {
    padding-bottom: 1%;
  }
}
@media screen and (max-width: 500px) {
  #YueSaiTryland {
    height: auto;
  }
}
</style>