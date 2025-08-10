import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
//引入小仓库
import home from './home/home'
import HuangShanHistory from './HuangShan/HuangShanHistory'
import HuangShanStep from './HuangShan/HuangShanStep'
import KeemunHistory from './Keemun/KeemunHistory'
import KeemunStep from './Keemun/KeemunStep'
import TaipingStep from './Taiping/TaipingStep'
import GuaPianStep from './GuaPian/GuaPianStep'
import HuoShanStep from './HuoShan/HuoShanStep'
import YueXiStep from './YueXi/YueXiStep'
import JinShaStep from './JinShan/JinShaStep'
import GegongStep from './Gegong/GegongStep'
//对外暴露store
export default new Vuex.Store({
    //实现Vuex仓库模块式开发存储数据
    modules:{
        home,
        HuangShanHistory,
        HuangShanStep,
        KeemunHistory,
        KeemunStep,
        TaipingStep,
        GuaPianStep,
        HuoShanStep,
        YueXiStep,
        JinShaStep,
        GegongStep
    }
})