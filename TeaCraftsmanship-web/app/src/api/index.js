//当前这个模块：对API进行统一管理
import home from "./home.js"
import HuangShanHistory from "./HuangshanMaofengTeaHistory.js"
import HuangshanStep from "./HuangshanMaofengTeaStep.js"
import KeemunHistory from "./KeemunHistory.js"
import KeemunStep from "./KeemunStep.js"
import TaipingStep from "./TaipingStep.js"
import GuaPianStep from "./GuapianStep.js"
import HuoShanStep from "./HuoshanStep.js"
import GegongStep from "./GegongStep.js"
import YueXiStep from "./YueXiStep.js"
import JinShan from "./JinShanStep.js"
//首页茶信息的介绍
export const reqhomeList=()=> home.get('/home/list')
//黄山毛峰的历史介绍
export const reqHuangShanHistoryList=()=> HuangShanHistory.get('/content/1')
//黄山毛峰的制作步骤
export const reqHuangShanStepList=()=> HuangshanStep.get('/content/make/1')
//祁门红茶的历史介绍
export const reqKeemunHistoryList=()=> KeemunHistory.get('/content/4')
//祁门红茶的制作步骤
export const reqKeemunStepList=()=> KeemunStep.get('/content/make/4')
//太平猴魁
export const reqTaipingStepList=()=> TaipingStep.get('/content/make/2')
//六安瓜片
export const reqGuaPianStepList=()=> GuaPianStep.get('/content/make/3')
//霍山黄芽
export const reqHuoShanStepList=()=> HuoShanStep.get('/content/make/5')
//葛工红茶
export const reqGegongStepList=()=> GegongStep.get('/content/make/6')
//岳西翠兰
export const reqYueXiStepList=()=> YueXiStep.get('/content/make/7')
//金山时雨
export const reqJinShanStepList=()=> JinShan.get('/content/make/8')