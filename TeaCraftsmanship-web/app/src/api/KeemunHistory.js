import axios from "axios";

// 创建一个新的 Axios 实例
const instance = axios.create({
    // // 基础路径，发请求的时候，路径中会出现 'tea'
    baseURL: '/tea',
    // 请求超时时间设置为 5 秒
    timeout: 5000
});
//请求拦截器：在发请求之前，请求拦截器可以检测到，可以在请求发出去之前做一下事情
instance.interceptors.request.use(
    (config) => {
        // 在发送请求之前做些什么
        // 添加请求头等操作
        return config;
    },
    (error) => {
        // 对请求错误做些什么
        return Promise.reject(error);
    }
);
//响应拦截器
instance.interceptors.response.use(
    (response) => {
        // 对响应数据做些什么
        // 统一处理响应数据等操作
        return response.data;
    },
    (error) => {
        // 对响应错误做些什么
        // 统一处理错误等操作
        console.error("请求失败:", error);
        return Promise.reject(error);
    }
);


// 导出封装后的请求方法
export default instance;
