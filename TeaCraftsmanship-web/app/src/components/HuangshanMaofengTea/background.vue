<template>
  <div id="bg">
    <div class="background-img">
      <div alt="">
        <div class="content">
          <h1 class="title">黄山毛峰</h1>
          <h2 class="title2">黄山之巅 毛峰传奇</h2>
          <div>高山出名茶，黄山自古以来就是名优茶的生产基地，早在明清年代，就有僧人采制高山野茶，手工制作了历史名茶北源茶、紫霞茶和黄山云雾茶</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "background",
};
</script>

<style scoped>
/* #bg {
  margin-left: 10%;
  margin-right: 10%;
} */
.background-img>div {
  width: 100%;
  height: 100%;
  background: url('https://hui-tea.oss-cn-hangzhou.aliyuncs.com/%E8%8C%B6%E5%8F%B6/%E9%BB%84%E5%B1%B1%E6%AF%9B%E5%B3%B0/%E9%BB%84%E5%B1%B1%E6%AF%9B%E5%B3%B0.jpg');
  background-size: 100% 100%;
  background-position: center;
}
.title {
  text-indent: 1em;
}
.content>div{
  text-indent: 2em;
  margin-left: 1em;
}
.content {
  padding-top: 70px;
  color: #fff;
  font-family: "Ma+Shan+Zheng",cursive;
  width: 24em ;
  margin-left: 5em;
}
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
    margin: 0px;
}
.content{
  margin-left: 2em;
  width: 80vw;
}
}
</style>