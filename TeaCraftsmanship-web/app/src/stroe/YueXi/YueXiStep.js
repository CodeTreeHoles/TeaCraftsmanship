import { reqYueXiStepList } from "@/api";

//actions:处理actions，可以书写自己的业务逻辑，也可以处理异步
const actions = {
    //通过API里面的接口函数调用,向服务器发请求,获取服务器的数据
    async YueXiStepList({ commit }) {
        //await:拿到Promise的返回结果,写了await就必须写async
        try {
            let result = await reqYueXiStepList();
            commit("GETYUEXISTEPLIST", result);
        } catch (error) {
            console.error("获取岳西翠兰信息失败:", error);
        }
    },
}
//mutations:修改state的唯一手段
const mutations = {
    GETYUEXISTEPLIST(state, YueXiStepList) {
        state.YueXiStepList = YueXiStepList
    },
}
//state:仓库存储数据的地方
const state = {
    //要根据服务器数据类型来定义
    YueXiStepList: [],
}
//getters:可以理解为计算属性，让组件获取仓库的数据更加方便
const getters = {}

export default {
    actions,
    mutations,
    state,
    getters
}