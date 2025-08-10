<template>
  <div :style="bgStyle" id="main">
    <div class="containerLine">
      <div class="line"></div>
      <div class="dot" style="--n: 0;" id="dot1" @click="clickDot(4)"><span>1</span></div>
      <div class="dot" style="--n: 1;" id="dot2" @click="clickDot(5)"><span>2</span></div>
      <div class="dot" style="--n: 2;" id="dot3" @click="clickDot(6)"><span>3</span></div>
      <div class="dot" style="--n: 3;" id="dot4" @click="clickDot(7)"><span>4</span></div>
      <div class="dot" style="--n: 4;" id="dot5" @click="clickDot(8)"><span>5</span></div>
      <div class="dot" style="--n: 5;" id="dot6" @click="clickDot(9)"><span>6</span></div>
      <div class="dot" style="--n: 6;" id="dot7" @click="clickDot(10)"><span>7</span></div>
      <div class="dot" style="--n: 7;" id="dot8" @click="clickDot(11)"><span>8</span></div>
    </div>

    <Introduce class="content" :inputName="getActiveId"></Introduce>


    <div class="swiper-container">
      <div class="swiper-wrapper">
        <div class="swiper-slide" v-for="(card, index) in imgsCard" :key="index">
          <div class="card" :style="{ backgroundImage: 'url(' + card.src + ')' }">
            <!-- <div>{{ getActiveId }}</div> -->
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import Swiper from 'swiper'
import "swiper/css/swiper.css"
import Introduce from '../Home/Introduce.vue';
export default {
  name: "Content",
  components: {
    Introduce
  },
  data() {
    return {
      // coverImgUrl: require("@/assets/image.png"),
      myswiper: null,
      t: 0,
      name: '12345',
      imgs: [
        {
          img: new Image(),
          src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/home/%E9%BB%84%E5%B1%B1%E6%AF%9B%E5%B3%B0%E9%A6%96%E9%A1%B5%E8%83%8C%E6%99%AF.jpg'
        },//黄山毛峰
        {img: new Image(), src:'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/home/%E7%A5%81%E9%97%A8%E7%BA%A2%E8%8C%B6%E9%A6%96%E9%A1%B5%E8%83%8C%E6%99%AF.jpg' },//祁门红茶
        {img: new Image(),src:'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/home/%E5%85%AD%E5%AE%89%E7%93%9C%E7%89%87%E9%A6%96%E9%A1%B5%E8%83%8C%E6%99%AF.jpg'},//六安瓜片
        {img: new Image(),src:"https://hui-tea.oss-cn-hangzhou.aliyuncs.com/home/%E5%A4%AA%E5%B9%B3%E7%8C%B4%E9%AD%81%E9%A6%96%E9%A1%B5%E8%83%8C%E6%99%AF.jpg"},//太平猴魁
        {img: new Image(),src:"https://hui-tea.oss-cn-hangzhou.aliyuncs.com/home/%E9%9C%8D%E5%B1%B1%E9%BB%84%E8%8A%BD.jpg"},//霍山黄芽
        {img: new Image(),src:"https://hui-tea.oss-cn-hangzhou.aliyuncs.com/home/%E8%91%9B%E5%85%AC%E7%BA%A2%E8%8C%B6.jpg"},//葛公红茶
        {img: new Image(),src:"https://hui-tea.oss-cn-hangzhou.aliyuncs.com/home/%E5%B2%B3%E8%A5%BF%E7%BF%A0%E5%85%B0%E9%A6%96%E9%A1%B5%E8%83%8C%E6%99%AF.jpg"},//岳西翠兰
        {img: new Image(),src:"https://hui-tea.oss-cn-hangzhou.aliyuncs.com/home/%E9%87%91%E5%B1%B1%E6%97%B6%E9%9B%A8%E9%A6%96%E9%A1%B5%E8%83%8C%E6%99%AF.jpg"}//金山时雨
      ],
      imgsCard: [
        {
          img: new Image(),
          src: "https://hui-tea.oss-cn-hangzhou.aliyuncs.com/home/%E9%BB%84%E5%B1%B1%E6%AF%9B%E5%B3%B0%E5%B0%8F%E5%9B%BE.jpg",//黄山毛峰
        },
        {
          img: new Image(),
          src: "https://hui-tea.oss-cn-hangzhou.aliyuncs.com/home/%E7%A5%81%E9%97%A8%E7%BA%A2%E8%8C%B6%E5%B0%8F%E5%9B%BE.jpg",//祁门红茶
        },
        {
          img: new Image(),
          src: "https://hui-tea.oss-cn-hangzhou.aliyuncs.com/home/%E5%85%AD%E5%AE%89%E7%93%9C%E7%89%87%E5%B0%8F%E5%9B%BE.jpg",//六安瓜片
        },
        {
          img: new Image(),
          src: "https://hui-tea.oss-cn-hangzhou.aliyuncs.com/home/%E5%A4%AA%E5%B9%B3%E7%8C%B4%E9%AD%81%E5%B0%8F%E5%9B%BE.jpg",//太平猴魁
        },
        {
          img: new Image(),
          src: "https://hui-tea.oss-cn-hangzhou.aliyuncs.com/home/%E9%9C%8D%E5%B1%B1%E9%BB%84%E8%8A%BD%E5%B0%8F%E5%9B%BE.jpg",//霍山黄芽
        },
        {
          img: new Image(),
          src: "https://hui-tea.oss-cn-hangzhou.aliyuncs.com/home/%E8%91%9B%E5%85%AC%E7%BA%A2%E8%8C%B6%E5%B0%8F%E5%9B%BE.jpg",//葛公红茶
        },
        {
          img: new Image(),
          src: "https://hui-tea.oss-cn-hangzhou.aliyuncs.com/home/%E5%B2%B3%E8%A5%BF%E7%BF%A0%E5%85%B0%E5%B0%8F%E5%9B%BE.jpg",//岳西翠兰
        },
        {
          img: new Image(),
          src: "https://hui-tea.oss-cn-hangzhou.aliyuncs.com/home/%E9%87%91%E5%B1%B1%E6%97%B6%E9%9B%A8%E5%B0%8F%E5%9B%BE.jpg",//金山时雨
        },
      ],
    }
  },
  mounted() {
    var myswiper = new Swiper('.swiper-container', {
      on: {
        slideChange() {
          // console.log('当前的slide序号是' + this.activeIndex);//或者swiper.activeIndex，swiper与this都可指代当前swiper实例

          //清空原本active的dot的样式

          // console.log(this.activeIndex);

          const dots = document.querySelectorAll('.dot');
          dots.forEach(dot => {
            if (dot.classList.contains('active')) {
              dot.classList.remove('active');
              dot.querySelector('span').style.display = 'none';
            }
          })

          //使dot随着swiper发生变化而发生变化
          const updateDot = (dot) => {
            document.getElementById(dot).classList.add('active')
            document.getElementById(dot).querySelector('span').style.display = 'block';
          }
          //swiper发生变化后dot也发生变化
          if (this.activeIndex == 4 || this.activeIndex == 12) {
            updateDot("dot1")
          } else if (this.activeIndex == 5 || this.activeIndex == 13) {
            updateDot("dot2")
          } else if (this.activeIndex == 6 || this.activeIndex == 14) {
            updateDot("dot3")
          } else if (this.activeIndex == 7 || this.activeIndex == 15) {
            updateDot("dot4")
          } else if (this.activeIndex == 8) {
            updateDot("dot5")
          } else if (this.activeIndex == 9 || this.activeIndex == 1) {
            updateDot("dot6")
          } else if (this.activeIndex == 10 || this.activeIndex == 2) {
            updateDot("dot7")
          } else if (this.activeIndex == 11 || this.activeIndex == 3) {
            updateDot("dot8")
          }
        },
      },
      // direction: 'vertical', // 垂直切换选项
      loop: true, // 循环模式选项
      // slidesPerView: 'auto',
      slidesPerView: 3.5,
      watchSlidesProgress: true,
      // slidesPerGroup: 3,
      // loopedSlides: 4,
      loopFillGroupWithBlank: true,
      // 如果需要分页器
      // pagination: {
      //   el: '.swiper-pagination',
      // },

      // 如果需要前进后退按钮
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },

      // 如果需要滚动条
      // scrollbar: {
      //   el: '.swiper-scrollbar',
      // },
    })
    this.myswiper = myswiper
    this.initDot()
  },
  methods: {
    setDot(index) {
      this.myswiper.progress = index
    },
    clickDot(index) {
      this.myswiper.slideTo(index, 100, false);
    },
    initDot() {
      const dots = document.querySelectorAll('.dot');

      dots.forEach(dot => {
        dot.addEventListener('click', () => {
          console.log(dot.textContent);


          if (!dot.classList.contains('active')) {
            dots.forEach(otherDot => {
              if (otherDot !== dot && otherDot.classList.contains('active')) {
                otherDot.classList.remove('active');
                otherDot.querySelector('span').style.display = 'none';
              }
            });

            dot.classList.add('active');
            dot.querySelector('span').style.display = 'block';
          }
        });
      });
    },
    setBgStyle() {
      var index = this.getActiveId;
      this.coverImgUrl = this.imgs[index - 1].img.src
      // if (index == 4) {
      //   this.coverImgUrl = this.imgs[1].img.src;
      // } else {
      //   this.coverImgUrl = this.imgs[0].img.src;
      // }
    },
    preloadImages() {
      this.imgs.forEach(item => {
        item.img.src = item.src;
      });
    },
  },
  created() {
    this.preloadImages();
  },
  computed: {
    getSwiper() {
      if (this.myswiper != null) {
        return this.myswiper.progress
      } else {
        return null
      }
    },
    bgStyle() {
      this.setBgStyle();
      return {
        backgroundImage: 'url(' + this.coverImgUrl + ')'
      }
    },
    getActiveId() {
      if (this.myswiper != null) {
        var index = this.myswiper.activeIndex
        // const uniqueId = this.$refs.myswiper.$el.children[activeIndex].dataset.id;
        // console.log(uniqueId);
        // 获取当前活动的滑块索引
        // return index
        if (index == 5 || index == 13) {
          return 2;
        } else if (index == 6 || index == 14) {
          return 3;
        } else if (index == 7 || index == 15) {
          return 4;
        } else if (index == 8) {
          return 5;
        } else if (index == 9 || index == 1) {
          return 6;
        } else if (index == 10 || index == 2) {
          return 7;
        } else if (index == 11 || index == 3) {
          return 8;
        }
        return 1;
      }
      return 1;
    }
  }
};
</script>

<style scoped>
#main {
  width: 100%;
  padding-top: 9vh;
  height: 91vh;
  display: flex;
  background-position: center;
  background-size: cover;
}

.content {
  margin: auto;
  margin-top: 15vh;
  width: 30%;
  /* height: 32vw; */
}

.swiper-container {
  width: 40vw;
  height: 25vw;
  margin-top: 25vh;
  margin-right: 2%;
  float: right;
}

@media screen and (min-device-width:800px) and (max-device-width:1200px) {
  .content {
    width: 40%;
    height: 45vw;
  }

  .swiper-container {
    width: 50vw;
    height: 30vw;
    margin-right: 0%;
  }
}

span {
  color: #000;
}

.swiper-slide {
  width: 25%;
}

.swiper-slide>div {
  transform: scale(0.8);
}

.swiper-wrapper>div>div {
  width: 100%;
  height: 70%;
  box-shadow: 0px 3px 5px #000a;
  border-radius: 7px;
}

.swiper-slide-active>div,
.swiper-slide-duplicate-active>div {
  transform: scale(0.95);
}

.box {
  width: 100px;
  height: 100px;
}

.containerLine {
  position: relative;
  height: 80%;
  float: left;
  /* padding: 25px; */
  padding-left: 5%;
  margin-top: 5%;
}

.line {
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  width: 1px;
  height: 100%;
  background-color: white;
}

.dot {
  width: 5px;
  height: 5px;
  background-color: white;
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 5px;
  position: absolute;
  top: calc(var(--n) * (100% / 7));
  /* 计算每个圆点在竖线上的位置 */
  left: 50%;
  transform: translate(-50%, -50%);
  cursor: pointer;
  transition: all 0.3s ease-in-out;
}

.dot span {
  display: none;
  font-size: 15px;
  color: white;
}

.dot.active span {
  display: block;
}

.dot.active {
  width: 15px;
  height: 15px;
}

.card {
  background-size: cover;
  background-position: center;
}

@media screen and (max-device-width:600px) {

  #main {
    /* margin-top: 18vh; */
    width: 100%;
    /* height:  21.5em; */
    display: block;
  }

  .content {
    width: 75%;
    height: 21.5em;
    padding: 0%;
    margin: auto;
    margin-top: 2vh;
  }

  .swiper-container {
    position: absolute;
    width: 90%;
    height: 52vw;
    padding-top: 10px;
    margin: 5%;
    bottom: 10px;
    /* float: none; */
    border: 5px;
  }

  .containerLine {
    font-size: 10px;
    height: 35em;
  }
}
</style>