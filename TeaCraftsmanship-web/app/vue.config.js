const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,

  //代理
  devServer: {
    proxy: {
      '/tea': {
        target: 'http://localhost:8081',  // 目标地址
        changeOrigin: true, // 是否改变原始地址
      },
      '/ai':{
        target: 'http://localhost:5000',  // 目标地址
        changeOrigin: true, // 是否改变原始地址
      }
    }
  }
})
