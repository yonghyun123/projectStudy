<template>
  <section>
    <study-header></study-header>
    <main>
      <body>
      <div class="card-expansion">
      <md-card v-for="item in items" :key="item.length">
        <md-card-media>
          <img :src="item.imgName">
        </md-card-media>

        <md-card-header >
          <div class="md-title">{{ item.usersEmail }}</div>
          <div class="md-subhead"> {{ "아직 테스트중" }}</div>
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
          imgFull: null,
        },
      ],
    };
  },
  components: {
    studyHeader: Header,
  },
  mounted() {
    this.axios.get('http://localhost:8081/projectStudy/study/')
    .then((res) => {
      this.items = res.data;
      console.log(res.data);
      console.log(this.items[0].usersEmail);
      console.log(this.items[0].imgName);
      const str = `../../src/assets${res.data[0].imgName}`;
      this.items[0].imgName = str;
    });
  },
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