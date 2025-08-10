<template>
    <div id="bg">
        <Title2></Title2>
        <div id="main">
            <br>
            <!-- <h2>AI茶画</h2> -->
            <div class="title"></div>
            <el-form>
                <el-form-item>
                    <el-input class="input-content" v-model="message"></el-input>
                    <el-button @click="send()" :disabled="show">发送</el-button>
                </el-form-item>
            </el-form>
            <div class="content">
                <div class="content-left">
                    <h3>
                        说明
                    </h3>
                    <div class="text">
                        <p>
                            我们欢迎您提供反馈和建议，以帮助我们改进绘画工具。您的意见对我们非常重要，我们会认真考虑并不断改进产品。
                        </p>
                        <p>
                            本功能是在Stable Diffusion模型的基础上进行封装后的产物，使用有道翻译api将用户输入的内容翻译为英文，以便识别用户需求。
                        </p>

                    </div>
                    <div class="imgl">
                    </div>
                </div>
                <div class="content-right">

                    <el-image :src="img">
                        <div slot="error" class="image-slot">
                            <span v-if="show">
                                请耐心等待...
                            </span>
                            <h3 v-if="!show">
                                展示区
                            </h3>
                        </div>
                    </el-image>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import instance from "@/api/AITea";
import Title2 from "../Title2.vue";
export default {
    data() {
        return {
            message: "",
            img: "",
            show: false
        }
    },
    components: {
        Title2
    },
    methods: {
        send() {
            const prompt = this.message
            if (prompt == "" || prompt == null) {
                alert("请输入需求")
                return;
            }
            this.img = ""
            this.show = true

            instance.post("/txt2img", { prompt: prompt }).then(res => {
                if (res == "0") {
                    alert("本模块未能进行部署,实属遗憾,可在介绍视频里查看本模块功能实现")
                    return;
                }
                console.log(res);
                this.img = res
                this.show = false
                // console.log(res.data)
            }).catch(error => {
                    alert("本模块未能进行部署,实属遗憾,可在介绍视频里查看本模块功能实现");
                    // 在这里处理请求失败的情况
                });
        }
    }
}
</script>

<style scoped>
#bg {
    background-color: rgb(228, 230, 216);
    height: 100vh;
}

#main {
    width: 75%;
    margin: auto;
    text-align: center;
}

.title {
    background: url("../../assets/AI茶画.png");
    height: 2em;
    margin: auto;
    width: 8em;
    background-size: cover;
}

.input-content {
    width: 80%;
}

.text {
    padding: 3em;
    padding-top: 1em;
    text-indent: 2em;
    text-align: left;
}

.content {
    width: 80%;
    margin: auto;
    display: flex;
}

.content-left {
    width: 48%;
    height: 512px;
    background: #fff;
    position: relative;
}

.content-right {
    width: 50%;
    height: 512px;
    /* border: 1px solid #000; */
    background: #fff;
    margin: auto;
    position: relative;
}

.image-slot {
    z-index: 1;
}

.imgl {
    background: url("../../assets/ai泡茶.png");
    background-size: cover;
    background-position: center;
    width: 70%;
    height: 14vw;
    position: absolute;
    bottom: 0;
    right: 0;
}
</style>
