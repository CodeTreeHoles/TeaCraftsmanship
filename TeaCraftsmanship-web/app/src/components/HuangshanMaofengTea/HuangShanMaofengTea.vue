<template>
  <div id="HuangShanMaoFengTea">
    <Background></Background>
    <Introduce></Introduce>
    <step></step>

  </div>
</template>

<script>
import Background from "../HuangshanMaofengTea/background.vue";
import Introduce from "../HuangshanMaofengTea/Introduce.vue";
import Step from "../HuangshanMaofengTea/Step.vue";
export default {
  name: "HuangShanMaoFengTea",
  components: {
    Background,
    Introduce,
    Step,
  },
};
</script>

<style scoped>
#HuangShanMaoFengTea {
  background-color: rgb(228, 230, 216);
  min-height: 100vh;
}
@media screen and (max-width: 2000px) {
  #HuangShanMaoFengTea {
    padding-bottom: 1%;
  }
}
@media screen and (max-width: 500px) {
  #HuangShanMaoFengTea {
    height: auto;
  }
}

</style>