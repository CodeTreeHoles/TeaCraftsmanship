  <template>
    <div id="nameList">
      <Title></Title>
      <div class="slot">
        <div class="slot-track">
          <div id="bg">
            <div v-for="(item, index) in items" :style="{ background: 'url(' + item + ')' }" :key="index"></div>
          </div>
        </div>
      </div>
      <div class="title">
        <div class="title-text">
          <div @click="printArrowup" class="arrow up"></div>
          <div class="text">安徽省茶叶非物质文化遗产名录</div>
          <div @click="printArrowdown" class="arrow down"></div>
        </div>
      </div>
      <transition-group appear name="book-transition">
        <div class="book" v-if="!showBook" key="book1">
          <div v-for="(item, index) in cards.slice(0, 10)" :key="index" :class="'b' + (index % 10 + 1)" id="delay"
            @mouseover="showCard(index)" @mouseleave="mouseleaveCard()">
            <router-link  :style="{ opacity: cardNumber == -1 || cardNumber == index ? 1 : 0.3 }" :to="{ path: '/map', query: { componentName: item.city } }"><img :src="item.src"
                alt="" /></router-link>
          </div>
        </div>

        <div class="book" id="book" v-if="showBook" key="book2">

          <div v-for="(item, index) in cards.slice(10, 19)" :key="index" :class="'b' + (index % 10 + 1)" id="delay"
            @mouseover="showCard(index)" @mouseleave="mouseleaveCard()">
            <router-link :style="{ opacity: cardNumber == -1 || cardNumber == index ? 1 : 0.3 }"  :to="{ path: '/map', query: { componentName: item.city } }"><img :src="item.src"/></router-link>
          </div>
        </div>


      </transition-group>
      <div id="FiveHundred">
        <div :class="'b' + (index+1)" v-for="(item, index) in cards" :key="index">
          <a href=""><img :src="item.src"/></a>
        </div>
      </div>

      <div class="Side-heading">
        <div class="side">
          <router-link to="/home">
            <div>首页</div>
          </router-link>
        </div>
        <div class="side">
          <router-link to="/huangshanmaofengtea">
            <div>徽茶</div>
          </router-link>
        </div>
        <div class="side">
          <router-link to="/map?componentName=黄山">
            <div>寻迹</div>
          </router-link>
        </div>

        <div class="side">
          <router-link to="/forum">
            <div>茶语论坛</div>
          </router-link>
        </div>
      </div>
    </div>
  </template>

<script>
export default {
  name: "NameLIst",
  data() {
    return {
      showBook: false, // 初始显示书籍内容
      items: [
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E4%B8%80%E6%A0%BC%E4%B8%8B.jpg',
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E4%BA%8C%E6%A0%BC.jpg',
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E4%B8%89%E6%A0%BC.jpg',//3
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E5%9B%9B%E6%A0%BC%E4%B8%8B.png',
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E4%BA%94%E6%A0%BC%E4%B8%8B.jpg',
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E5%85%AD%E6%A0%BC%E4%B8%8B.jpg',//6
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E4%B8%83%E6%A0%BC%E4%B8%8B.jpg',
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E5%85%AB%E6%A0%BC%E4%B8%8A.jpg',
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E4%B9%9D%E6%A0%BC%E4%B8%8B.jpg',//9
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E5%8D%81%E6%A0%BC%E4%B8%8B.png',
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E4%BA%8C%E5%8D%81%E4%BA%8C%E6%A0%BC%E4%B8%8B.jpg',
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E4%B9%9D%E6%A0%BC%E4%B8%8B.jpg',//12
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E5%8D%81%E4%B8%89%E6%A0%BC%E4%B8%8B.jpg',
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E5%8D%81%E5%9B%9B%E6%A0%BC%E4%B8%8B.jpg',
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E5%8D%81%E4%B9%9D%E6%A0%BC%E4%B8%8B.jpg',//15
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E5%8D%81%E5%85%AD%E6%A0%BC%E4%B8%8B.jpg',
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E5%8D%81%E4%B8%83%E6%A0%BC%E4%B8%8B.jpg',
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E4%B8%80%E6%A0%BC%E4%B8%8B.jpg',//18
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E4%BA%8C%E5%8D%81%E4%BA%8C%E6%A0%BC%E4%B8%8B.jpg',
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E4%B9%9D%E6%A0%BC%E4%B8%8B.jpg',
        'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E4%BA%8C%E5%8D%81%E4%BA%8C%E6%A0%BC%E4%B8%8B.jpg',//21
      ],
      cards: [
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E9%BB%84%E5%B1%B1%E6%AF%9B%E5%B3%B0.jpg',city:"黄山" },
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/2%E7%A5%81%E9%97%A8%E7%BA%A2%E8%8C%B6.jpg',city:"黄山" },
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/3%E5%A4%AA%E5%B9%B3%E7%8C%B4%E9%AD%81.jpg',city:"黄山" },
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/4%E5%85%AD%E5%AE%89%E7%93%9C%E7%89%87.jpg',city:"六安" },
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/5%E8%91%9B%E5%85%AC%E7%BA%A2%E8%8C%B6.jpg',city:"池州" },
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/6%E9%9C%8D%E5%B1%B1%E9%BB%84%E8%8A%BD.jpg',city:"六安" },
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/7%E5%B2%B3%E8%A5%BF%E7%BF%A0%E5%85%B0.jpg',city:"安庆" },
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/8%E9%87%91%E5%B1%B1%E6%97%B6%E9%9B%A8.jpg',city:"宣城" },
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/9%E5%B1%AF%E6%BA%AA%E7%BB%BF%E8%8C%B6.jpg',city:"黄山" },
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/10%E6%9D%BE%E8%90%9D%E8%8C%B6.jpg',city:"黄山" },
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/11%E5%AE%89%E8%8C%B6.jpg',city:"黄山" },//1
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/12%E8%88%92%E5%9F%8E%E5%B0%8F%E5%85%B0%E8%8A%B1.jpg',city:"六安" },
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/13%E7%9F%B3%E5%8F%B0%E9%9B%BE%E9%87%8C%E9%9D%92%E7%BB%BF%E8%8C%B6.jpg',city:"池州" },
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/14%E6%A1%90%E5%9F%8E%E5%B0%8F%E8%8A%B1.jpg',city:"安庆" },
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/15%E7%8F%A0%E5%85%B0%E8%8A%B1%E8%8C%B6.jpg',city:"黄山" },
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/16%E5%AE%BF%E6%9D%BE%E9%A6%99%E8%8A%BD.jpg',city:"安庆" },
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/17%E7%91%9E%E8%8D%89%E9%AD%81.png',city:"宣城" },
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/18%E6%B6%8C%E6%BA%AA%E7%81%AB%E9%9D%92.jpg',city:"宣城" },
        { src: 'https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/19%E5%A1%94%E6%B3%89%E4%BA%91%E9%9B%BE.jpg',city:"宣城" },
      ],
      cardNumber: -1
    };
  },
  methods: {
    printArrowup() {
      this.showBook = !this.showBook;
      console.log("上");
    },
    printArrowdown() {
      this.showBook = !this.showBook;
      console.log("下");
    },
    showCard(index) {
      clearTimeout(this.timer1);
      this.timer2 = setTimeout(() => {
        this.cardNumber = index
      }, 500);
    },
    mouseleaveCard() {
      clearTimeout(this.timer2);
      this.timer1 = setTimeout(() => {
        this.cardNumber = -1
      }, 1000);
    }
  },
};
</script>


<style scoped>
#bg {
  display: flex;
  background: url('https://hui-tea.oss-cn-hangzhou.aliyuncs.com/nameList/%E7%AC%AC%E5%8D%81%E4%BA%94%E6%A0%BC%E4%B8%8B.jpg');
  height: 100vh;
  width: 100vw;
  /* opacity:0; */
}

#bg>div {
  width: calc(100vw / 21);
  height: 100vh;
}

#Title {
  display: none;
}

#FiveHundred {
  display: none;
}

.slot {
  display: flex;
  position: fixed;
  /* 添加 fixed 定位 */
  top: 50%;
  /* 将图片容器垂直居中 */
  left: 0;
  /* 使图片容器固定在页面最左边 */
  transform: translateY(-50%);
  /* 垂直居中 */
}

.slot .slot-track div>img {
  vertical-align: middle;
  width: 100%;
  height: 100%;
}

.slot .slot-track {
  flex: 1;
}

.title {
  position: absolute;
  top: 25vh;
  bottom: 25%;
  left: 8.6%;
}

.title-text {
  writing-mode: vertical-rl;
  /* 让文字从上到下竖着写 */
  vertical-align: middle;
  font-size: 26px;
  letter-spacing: 0;
  color: white;
  position: relative;
}

.arrow {
  position: absolute;
  left: 50%;
  /* 水平居中 */
  transform: translateX(-50%);
  width: 34px;
  height: 24px;
  cursor: pointer;
  /* 添加光标样式 */
  filter: brightness(0) invert(100%);
}

.up {
  top: -30px;
  /* 上箭头在文字正上方 */
  background: url("../../assets/箭头.png") no-repeat;
}

.down {
  bottom: -30px;
  /* 下箭头在文字正下方 */
  transform: translateX(-50%) rotate(180deg);
  background: url("../../assets/箭头.png") no-repeat;
}

.title-text {
  writing-mode: vertical-rl;
  /* 让文字从上到下竖着写 */
  vertical-align: middle;
  font-size: 26px;
  letter-spacing: 0;
  color: white;
  position: relative;
}

.book-transition-enter-active,
.book-transition-leave-active {
  transition: opacity 1s ease-in-out;
  /* 定义过渡效果 */
}

.book-transition-enter,
.book-transition-leave-to {
  opacity: 0;
  /* 定义进入和离开时的初始状态 */
}

.book div img {
  width: calc(100vw / 10.5);
  position: absolute;
  transition:
    width 2s,
    height 2s,
    opacity 2s ease;
}

.book div img:hover {
  width: calc(100vw / 7 - 1px);
  z-index: 1;
}

.book .b1 img {
  left: 14.3%;
  bottom: 33vh;
}

.book .b2 img {
  left: 23.81%;
  bottom: 23vh;
}

.book .b3 img {
  left: 28.6%;
  bottom: 57.9vh;
}

.book .b4 a img {
  left: 38.1%;
  bottom: 44.7vh;
}

.book .b5 a img {
  left: 38.1%;
  bottom: 10vh;
}

.book .b6 a img {
  left: 47.65%;
  bottom: 56.5vh;
}

.book .b7 a img {
  left: 57.21%;
  bottom: 30.5vh;
}

.book .b8 a img {
  left: 71.39%;
  bottom: 55.5vh;
}

.book .b9 a img {
  left: 76.17%;
  bottom: 13vh;
}

.book .b10 a img {
  left: 85.74%;
  bottom: 40vh;
}

.Side-heading {
  height: 32%;
  position: absolute;
  top: 30vh;
  transform: translateX(-215%);
  transition: transform 0.5s ease, background-color 0.5s ease;
}

.Side-heading:hover {
  transform: translateX(-100%);
}

.Side-heading .side {
  height: 8vh;
  line-height: 8vh;
  text-align: center;
  border: 1px rgb(149, 162, 155) solid;
  border-radius: 10px;
  width: 200%;
  margin-top: 10%;
  margin-bottom: 10%;
  position: relative;
  left: 20px;
  background: rgb(149, 162, 155);
}

.Side-heading .side div {
  align-items: center;
  position: relative;
  left: 20px;
  color: white;
}

@media screen and (max-device-width: 500px) {

  .Side-heading,
  .arrow,
  .up,
  .down {
    display: none;
  }

  .title {
    transform: translateY(-28%);
    left: 12%;
  }

  .title-text {
    writing-mode: horizontal-tb;
    font-size: 20px;
  }

  .book {
    display: none;
  }

  #FiveHundred {
    display: block;
  }

  #FiveHundred div a img {
    width: 35%;
    position: absolute;
  }

  #FiveHundred .b1 a img {
    left: 11%;
    bottom: 40vh;
  }

  #FiveHundred .b2 a img {
    left: 54%;
    bottom: 40vh;
  }

  #FiveHundred .b3 a img {
    left: 11%;
    bottom: 4vh;
  }

  #FiveHundred .b4 a img {
    left: 54%;
    bottom: 4vh;
  }

  #FiveHundred .b5 a img {
    left: 11%;
    bottom: -32vh;
  }

  #FiveHundred .b6 a img {
    left: 54%;
    bottom: -32vh;
  }

  #FiveHundred .b7 a img {
    left: 11%;
    bottom: -68vh;
  }

  #FiveHundred .b8 a img {
    left: 54%;
    bottom: -68vh;
  }

  #FiveHundred .b9 a img {
    left: 11%;
    bottom: -104vh;
  }

  #FiveHundred .b10 a img {
    left: 54%;
    bottom: -104vh;
  }

  #FiveHundred .b11 a img {
    left: 11%;
    bottom: -138vh;
  }

  #FiveHundred .b12 a img {
    left: 54%;
    bottom: -138vh;
  }

  #FiveHundred .b13 a img {
    left: 11%;
    bottom: -176vh;
  }

  #FiveHundred .b14 a img {
    left: 54%;
    bottom: -176vh;
  }

  #FiveHundred .b15 a img {
    left: 11%;
    bottom: -212vh;
  }

  #FiveHundred .b16 a img {
    left: 54%;
    bottom: -212vh;
  }

  #FiveHundred .b17 a img {
    left: 11%;
    bottom: -248vh;
  }

  #FiveHundred .b18 a img {
    left: 54%;
    bottom: -248vh;
  }

  #FiveHundred .b19 a img {
    left: 11%;
    bottom: -284vh;
  }

  #Title {
    display: block;
  }
}
</style>
