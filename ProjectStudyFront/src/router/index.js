import Vue from 'vue';
import Router from 'vue-router';

// components
const Main = () => import('../components/Main');
const Login = () => import('../components/Login');
const Signup = () => import('../components/Signup');

Vue.use(Router);

const routes = [
  {
    path: '/',
    name: 'Main',
    component: Main,
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
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
