<template>
  <div id="HuoshanHuangyaTea">
    <Background></Background>
    <Introduce></Introduce>
    <step></step>
  </div>
</template>

<script>
import Background from "../HuoshanHuangyaTea/background.vue"
import Introduce from "../HuoshanHuangyaTea/Introduce.vue"
import Step from '../HuoshanHuangyaTea/Step.vue'
export default {
    name:"HuoshanHuangyaTea",
    components:{
        Background,
        Introduce,
        Step
    }

}
</script>

<style scoped>
#HuoshanHuangyaTea {
  background-color: rgb(228, 230, 216);
  min-height: 100vh;
}
@media screen and (max-width: 2000px) {
  #HuoshanHuangyaTea {
    padding-bottom: 1%;
  }
}
@media screen and (max-width: 500px) {
  #HuoshanHuangyaTea {
    height: auto;
  }
}
</style>