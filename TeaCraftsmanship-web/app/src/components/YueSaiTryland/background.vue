<template>
  <div id="background">
    <div class="background-img">
      <div></div>
    </div>
  </div>
</template>

<script>
export default {
    name:"background"
}
</script>

<style scoped>
/* #background {
  margin-left: 10%;
  margin-right: 10%;
} */
@media screen and (max-width: 2000px) {
  .background-img {
    height: 38vh;
  }
}
@media screen and (min-width: 2000px) {
  .background-img {
    height: 25.5vh;
  }
}
@media screen and (max-width: 500px) {
  #background {
  margin-left: 0 !important;
  margin-right: 0 !important;
}
}
.background-img div{
  background: url("https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E5%B2%B3%E8%A5%BF%E7%BF%A0%E5%85%B0/%E5%B2%B3%E8%A5%BF%E7%BF%A0%E5%85%B0.jpg");
  background-position: center;
  background-size: cover;
  width: 100%;
  height: 100%;
}
</style>