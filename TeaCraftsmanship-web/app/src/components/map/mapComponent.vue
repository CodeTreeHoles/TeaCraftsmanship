<template>
  <div id="main" class="bg">
    <Title></Title>
    <div id="map" v-if="center.length == 2">
      <amap tileSize="1" :center="center" :zoom="zoom" :show-indoor-map="false" map-style="amap://styles/fresh">

        <div v-for="(item) of info" :key="item.id">
          <amap-info-window v-if="Window == item.id" :position="[item.x, item.y]" :offset="[0, -34]" is-custom>
            <div class="info-window-content">
              <h3>{{ item.name }}</h3>
              <el-image class="img" :src="item.img"></el-image>
            </div>
          </amap-info-window>

          <amap-marker :position="[item.x, item.y]" clickable @click="clickMarker(item.id)"></amap-marker>
        </div>

      </amap>
    </div>
    <div class="content">

      <div class="box" :style="{ left: (index * len) + 'vw', width: (80 / info.length) + 'vw'}"
        v-for="(item, index) of info" :key="item.id" @click="action(90 / info.length)">
        <div class="card-title">{{ item.name }}</div>
        <hr>
        <!-- <el-divider></el-divider> -->
        <div class="card-content">{{ item.content }}</div>
      </div>

    </div>
  </div>
</template>

<script>
import Title from '../Title2.vue';
import instance from '@/api/home';
import Swiper from 'swiper'
import "swiper/css/swiper.css"
export default {
  name: "mapComponent",
  data() {
    return {
      myswiper: null,
      center: [], // 设置地图中心点经纬度
      zoom: 10, // 设置地图缩放级别
      markerPosition: [], // 设置标记点位置经纬度
      content: "",
      areas: [],
      areaIds: [],
      pitch: 45,
      rotation: 15,
      Window: -1,
      name: "黄山",   //入口
      info: [],
      box: "box",
      len: 2
    };
  },
  components: {
    Title
  },
  methods: {
    getCenter() {
      instance.get("/area", {
        params: {
          name: this.name
        }
      }).then(res => {
        this.center.push(res.data.x)
        this.center.push(res.data.y)
        // console.log(this.center);
      })
    },
    getInfo() {
      instance.get("/track/city", {
        params: {
          city: this.name
        }
      }).then(res => {
        // console.log(res.data);
        this.info = res.data
      })
    },
    clickMarker(id) {
      this.Window = id
    },
    action(len) {
      if(window.innerWidth < 800){
        len = len
      }else{
        len =13
      }
      if (this.len == 2) {
        this.len = len + 1
      } else {
        this.len = 2
      }
    }
  },
  mounted() {
    var myswiper = new Swiper('.swiper-container', {
      loop: true, // 循环模式选项
      // slidesPerView: 'auto',
      slidesPerView: 2,
      watchSlidesProgress: true,
      // slidesPerGroup: 3,
      // loopedSlides: 4,
      loopFillGroupWithBlank: true,
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
    })
    this.myswiper = myswiper
  },
  created() {
    const componentName = this.$route.query.componentName;
    this.name = componentName
    this.getCenter()
    this.getInfo()
  },
  computed: {
    paragraphs() {
      return this.content.split('\\r');
    }
  },
  watch: {
    $route() {
      this.name = this.$route.query.componentName; // 获取路由参数
      this.center = []
      this.getCenter()
      this.getInfo()
    },
  }

};
</script>

<style scoped>
/* 可选：添加样式 */
hr {
  margin: 5px;
}

#main {
  min-height: 100vh;
  background: #f6f3e5;
}

.bg {
  background-color: rgb(230, 230, 216);
}

#map {
  width: 100%;
  margin: auto;
  height: 50vh;
}

.el-divider--horizontal {
  margin-top: 1em;
  margin-bottom: 1em;
}

.content {
  width: 95%;
  margin: auto;
  font-size: 19px;
  line-height: 1.4em;
  display: flex;
  position: absolute;
  left: 2em;
}

.info-window-content {
  background: #fff;
  padding: 10px;
  box-shadow: 0px 0px 2px #000;
  margin: auto;
}

.img {
  height: 12vh;
}

h3 {
  text-align: center;
}

.box {
  margin-top: 2em;
  margin-right: 2.5em;
  font-size: 14px;
  position: absolute;
  background: url('../../assets/card1.png');
  background-size: 100% 100%;
  box-shadow: -2px 0px 5px #0008;
  /* border-radius: 5px; */
  min-height: 17em;
  color: #fff;
  padding: 0.5em;
  max-width: 12vw;
}

.card-content {
  text-indent: 2em;
}

.card-title {
  font-size: 16px;
  text-align: center;

}

.box:hover {
  transform: scale(1.12) translate(-0.5em) translateY(-1.1em);
  cursor: pointer;
}

.indented-paragraph {
  text-indent: 2em;
  /* 设置首行缩进为 2 个 em */
}

@media screen and (max-device-width: 500px) {
  #main{
    height: auto;
  }
  #map {
    /* width: 70%; */
    height: 55h;
  }

  h3 {
    font-size: 17px;
  }

  .content {
    font-size: 15px;
    line-height: 0.8em;
    width: 100%;
    height: 25em;
    position: static;
  }

  .card-title {
    font-size: 10px;
  }

  .card-content {
    font-size: 8px;
    text-indent: 2em;
  }

  .box {
    min-height: 20em;
    max-width: 20vw;
  }

  .box:hover {
    transform: none;
  }

  .img {
    height: 8vh;
  }
}

@media screen and (min-device-width: 2000px) {
  .card-title {
    font-size: 24px;
  }

  .box {
    font-size: 22px;
    margin-top: 3em;
  }
}
</style>
