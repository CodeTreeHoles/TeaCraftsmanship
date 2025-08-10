<template>
 <div id="app">
  <Title v-show="$route.meta.show"></Title>
  <router-view></router-view>
  <!-- <login></login> -->
  <!-- <mapComponent></mapComponent> -->
  <!-- <popup></popup> -->
 </div>
</template>

<script>
export default {
  name: 'App',
  components: {
  },
  mounted() {
    if (localStorage.getItem("expireTime") < new Date().getTime()) {
      localStorage.removeItem("expireTime")
      localStorage.removeItem('jwt');
      localStorage.removeItem('userId');
      localStorage.removeItem('avatar');
      localStorage.removeItem('username');
      localStorage.removeItem('password');
    }
  }
}
</script>

<style>



</style>
