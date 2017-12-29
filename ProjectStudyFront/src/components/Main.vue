<template>
<body id="page-top">
    <!-- Navigation -->
    <b-nav v-b-scrollspy:nav-scroller class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-item" href="#page-top" @click="scrollIntoView">Start Bootstrap</a>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="#about" @click="scrollIntoView">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#services" @click="scrollIntoView">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#contact" @click="scrollIntoView">Contact</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#signin" @click="signin()">Signin</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#signup" @click="signup()">Signup</a>
            </li>
          </ul>
        </div>
      </div>
    </b-nav>
    <b-card-body id = "nav-scroller" ref="content" style="position:relative; height:550px; overflow-y:scroll;">
      <section id="main" >
        <div class="container">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h1>Welcome to Scrolling Nav</h1>
              <p class="lead">A landing page template freshly redesigned for Bootstrap 4</p>
            </div>
          </div>
        </div>
      </section>

      <section id="about"  class="bg-light">
        <div class="container">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h2>About this page</h2>
              <p class="lead">This is a great place to talk about your webpage. This template is purposefully unstyled so you can use it as a boilerplate or starting point for you own landing page designs! This template features:</p>
              <ul>
                <li>Clickable nav links that smooth scroll to page sections</li>
                <li>Responsive behavior when clicking nav links perfect for a one page website</li>
                <li>Bootstrap's scrollspy feature which highlights which section of the page you're on in the navbar</li>
                <li>Minimal custom CSS so you are free to explore your own unique design options</li>
              </ul>
            </div>
          </div>
        </div>
      </section>

      <section id="services">
        <div class="container">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h1>Services we offer</h1>
              <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aut optio velit inventore, expedita quo laboriosam possimus ea consequatur vitae, doloribus consequuntur ex. Nemo assumenda laborum vel, labore ut velit dignissimos.</p>
            </div>
          </div>
        </div>
      </section>

      <section id="contact" class="bg-light">
        <div class="container">
          <div class="row">
            <div class="col-lg-8 mx-auto">
              <h1>Contact us</h1>
              <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vero odio fugiat voluptatem dolor, provident officiis, id iusto! Obcaecati incidunt, qui nihil beatae magnam et repudiandae ipsa exercitationem, in, quo totam.</p>
            </div>
          </div>
        </div>
      </section>
    </b-card-body>
    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
      </div>
      <!-- /.container -->
    </footer>
</body>
</template>

<script>
export default {
  name: 'Main',
  methods: {
    scrollIntoView(evt) {
      evt.preventDefault();
      const href = evt.target.getAttribute('href');
      const el = href ? document.querySelector(href) : null;
      if (el) {
        this.$refs.content.scrollTop = el.offsetTop;
      }
    },
    signin() {
      this.$router.push({ name: 'Signin' });
    },
    signup() {

    },
  },
};

</script>
<style lang="scss">
section#about{
  padding: 200px 0;
}
section#services{
  padding: 200px 0;
}
section#contact{
  padding: 200px 0;
}
section#main{
  padding: 200px 0;
}
</style>