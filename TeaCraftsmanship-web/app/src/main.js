import Vue from 'vue'
import App from './App.vue'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
//注册全局组件
//标题
import Title from '@/components/Title.vue'
//弹出框
import popup from '@/components/Popup/popup.vue'
Vue.component(Title.name, Title)
Vue.component(popup.name,popup)
//引入仓库（Vuex）
import store from './stroe'
//引入路由
import router from './router/index'
//引入动画效果
import 'animate.css'

import AmapVue from '@amap/amap-vue';
AmapVue.config.version = '2.0'; // 默认2.0，这里可以不修改
AmapVue.config.key = '706c389fd08e0b29a31d84df30878cc3';
AmapVue.config.plugins = [
  'AMap.ToolBar',
  'AMap.MoveAnimation',
];
Vue.use(AmapVue);

Vue.config.productionTip = false
// Vue.prototype.avatar = 

Vue.use(ElementUI);
new Vue({
  render: h => h(App),
  //注册仓库
  store,
  //注册路由
  router
}).$mount('#app')
