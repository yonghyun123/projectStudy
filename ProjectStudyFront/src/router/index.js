import Vue from 'vue';
import Router from 'vue-router';
import VueGoodTable from 'vue-good-table';

// components
const Login = () => import('../components/Login');
const Main = () => import('../components/Main');
const Signup = () => import('../components/Signup');

Vue.use(Router);
Vue.use(VueGoodTable);

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
