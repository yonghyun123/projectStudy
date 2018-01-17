import Vue from 'vue';
import Router from 'vue-router';

// components
const Main = () => import('../components/Main');
const StudyMain = () => import('../components/StudyMain');
const Signin = () => import('../components/Signin');
const Signup = () => import('../components/Signup');
const AddStudy = () => import('../components/AddStudy');

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
  {
    path: '/studymain',
    name: 'StudyMain',
    component: StudyMain,
  },
  {
    path: '/addstudy',
    name: 'AddStudy',
    component: AddStudy,
  },

];

const router = new Router({
  routes,
});

export default router;
