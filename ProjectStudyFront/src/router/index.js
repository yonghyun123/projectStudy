import Vue from 'vue';
import Router from 'vue-router';

// components
const Main = () => import('../components/Main');
const Signin = () => import('../components/Signin');
const Signup = () => import('../components/Signup');

Vue.use(Router);

const routes = [
  {
    path: '/',
    name: 'Main',
    component: Main,
  },
  {
    path: '/signin',
    name: 'Signin',
    component: Signin,
  },
  {
    path: '/signup',
    name: 'Signup',
    component: Signup,
  },
];

const router = new Router({
  routes,
});

export default router;
