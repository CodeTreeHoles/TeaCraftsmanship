//配置路由的地方
import vue from 'vue'
import VueRouter from 'vue-router'
//使用插件
vue.use(VueRouter)
//引入路由组件
import Home from "@/components/Home/Home.vue"
import HuangshanMaofengTea from '@/components/HuangshanMaofengTea/HuangShanMaofengTea.vue'
import GuapianTea from '@/components/GuapianTea/GuapianTea.vue'
import KeemunBlackTea from '@/components/KeemunBlackTea/KeemunBlackTea.vue'
import TaipingHoukui from '@/components/TaipingHoukui/TaipingHoukui.vue'
import NameList from '@/components/NameList/NameList.vue'
import HuoshanHuangyaTea from '@/components/HuoshanHuangyaTea/HuoshanHuangyaTea.vue'
import JinShanRain from '@/components/JinShanRain/JinShanRain.vue'
import YueSaiTryland from '@/components/YueSaiTryland/YueSaiTryland.vue'
import GegongBlackTea from '@/components/GegongBlackTea/GegongBlackTea.vue'
import Login from '@/components/login/login.vue'
import Register from '@/components/Register/register.vue'
import forum from '@/components/Forum/forum.vue'
import mapComponent from '@/components/map/mapComponent.vue'
import about from '@/components/about/about.vue'
import AITea from '@/components/AITea/AITea.vue'
//配置路由
export default new VueRouter({
    routes: [
        //主页
        {
            path: '/home',
            component: Home,
            meta: { show: true }
        },
        {
            path:'/AI',
            component:AITea,
            meta:{show:false}
        },
        //黄山毛峰
        {
            path: '/huangshanmaofengtea',
            component: HuangshanMaofengTea,
            meta: { show: true }
        },
        //祁门红茶
        {
            path: '/keemunblacktea',
            component: KeemunBlackTea,
            meta: { show: true }
        },
        //太平猴魁
        {
            path: '/taipinghoukuitea',
            component: TaipingHoukui,
            meta: { show: true }
        },
        //六安瓜片
        {
            path: '/guapiantea',
            component: GuapianTea,
            meta: { show: true }
        },
        //霍山黄芽
        {
            path: '/huoshanhuangyatea',
            component: HuoshanHuangyaTea,
            meta: { show: true }
        },
        //金山时雨
        {
            path:'/jinshanrainteatea',
            component: JinShanRain,
            meta: { show: true }
        },
        //岳西翠兰
        {
            path:'/yuesaitrylandtea',
            component: YueSaiTryland,
            meta: { show: true }
        },
        //葛工红茶
        {
            path:'/gegongblacktea',
            component:GegongBlackTea,
            meta:{show:true}
        },
        //论坛
        {
            path:'/forum',
            component: forum,
            meta: { show: false }
        },
        //名单
        {
            path: '/namelist',
            component: NameList,
            meta: { show: false }
        },
        //登录
        {
            path: '/login',
            component: Login,
            meta: { show: false }
        },
        //注册
        {
            path:'/register',
            component: Register,
            meta: { show: false }
        },
        {
            path:'/map',
            component:mapComponent,
            meta: { show: false }
        },
        {
            path:'/about',
            component:about,
            meta: { show: true }
        },
        //重定向，在项目跑起来的时候，访问/，立马跳转到首页
        {
            path: '*',
            redirect: '/home'
        }

    ]
})