<template>
  <section>
    <study-header></study-header>
    <main>
      <body>
      <div class="card-expansion">
      <md-card v-for="item in items" :key="item.length">
        <md-card-media>
          <img :src="item.imgFull">
        </md-card-media>

        <md-card-header >
          <div class="md-title">{{ item.usersEmail }}</div>
          <div class="md-subhead"> {{ item.imgName }}</div>
        </md-card-header>

        <md-card-expand>
          <md-card-actions md-alignment="space-between">
            <div>
              <md-button>Action</md-button>
              <md-button>Action</md-button>
            </div>

            <md-card-expand-trigger>
              <md-button class="md-icon-button">
                <md-icon>keyboard_arrow_down</md-icon>
              </md-button>
            </md-card-expand-trigger>
          </md-card-actions>

          <md-card-expand-content>
            <md-card-content>
              Lorem ipsum dolor sit amet, consectetur adipisicing elit. Optio itaque ea, nostrum odio. Dolores, sed accusantium quasi non, voluptas eius illo quas, saepe voluptate pariatur in deleniti minus sint. Excepturi.
            </md-card-content>
          </md-card-expand-content>
        </md-card-expand>
      </md-card>
      </div>
      </body>
    </main>
    <footer></footer>
  </section>
</template>

<script>
const Header = () => import('../components/Header');

export default {
  name: 'StudyMain',
  data() {
    return {
      items: [
        {
          usersEmail: null,
          imgName: null,
          imgFull: '../../src/assets/s_bb6a9a84-687b-4049-9da7-6c3f31fb4e0d_6.jpg',
        },
      ],
    };
  },
  components: {
    studyHeader: Header,
  },
  // mounted() {
  //   this.axios.get('http://localhost:8081/projectStudy/study/')
  //   .then((res) => {
  //     // this.items = res.data;
  //     console.log(res.data);
  //     // console.log(this.items[0].usersName);
  //     // console.log(this.items[0].imgFull);
  //   });
  // },
  methods: {

  },
};
</script>

<style lang="scss" scoped>
  .card-expansion {
    max-width: 640px; 
    padding-top: 50px;
    margin-right: auto;
    margin-left: auto;
    height: 480px;
  }

  .md-card {
    width: 300px;
    margin: 4px;
    display: inline-block;
    vertical-align: top;
  }

  .md-card-media img {
    height: 250px;
  }

  body{

   #loginBtn {
      width: 100%;
    }

  }

</style>