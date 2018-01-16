<template>
<body id="page-top">
    <!-- Navigation -->
    <b-nav v-b-scrollspy:nav-scroller class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-item" href="#page-top" @click="gotomain()">공부하자 얘들아</a>
        <div class="collapse navbar-collapse" id="navbarResponsive">
        </div>
      </div>
    </b-nav>
</body>
</template>

<<script>
export default {
  name: 'StudyMain',
  methods: {
    gotomain() {
      this.$router.push('Main');
    },
  },
};
</script>
