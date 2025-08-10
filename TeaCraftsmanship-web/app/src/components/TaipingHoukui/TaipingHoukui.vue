<template>
  <div id="TaipingHoukui">
    <background></background>
    <Step></Step>
    <Introduce></Introduce>
  </div>
</template>

<script>
import background from '../TaipingHoukui/background.vue'
import Step from '../TaipingHoukui/Step.vue';
import Introduce from '../TaipingHoukui/Introduce.vue';
export default {
    name:"TaipingHoukui",
    components:{
        background,
        Step,
        Introduce
    }
}
</script>

<style scoped>
#TaipingHoukui {
  background-color: rgb(228, 230, 216);
  min-height: 100vh;
}
@media screen and (max-width: 2000px) {
  #TaipingHoukui {
    padding-bottom: 1%;
  }
}
@media screen and (max-width: 500px) {
  #TaipingHoukui {
    height: auto;
  }
}

</style>