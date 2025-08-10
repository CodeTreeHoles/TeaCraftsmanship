<template>
  <div id="GegongBlackTea">
    <background></background>
    <Step></Step>
    <Introduce></Introduce>
  </div>
</template>

<script>
import background from '../GegongBlackTea/background.vue'
import Step from '../GegongBlackTea/Step.vue';
import Introduce from '../GegongBlackTea/Introduce.vue';
export default {
    name:"GegongBlackTea",
    components:{
        background,
        Step,
        Introduce
    }
}
</script>

<style scoped>
#GegongBlackTea {
  background-color: rgb(228, 230, 216);
  min-height: 100vh;
}
@media screen and (max-width: 2000px) {
  #GegongBlackTea {
    padding-bottom: 1%;
  }
}
@media screen and (max-width: 500px) {
  #GegongBlackTea {
    height: auto;
  }
}

</style>