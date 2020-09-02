import Vue from 'vue'
import Router from 'vue-router'
import BlogDetail from '../views/BlogDetail'
import Login from '../views/Login'
import BlogEdit from '../views/BlogEdit'
import Blogs from '../views/Blogs'
import Register from "../views/Register";


Vue.use(Router)

let routes = [
    {
      path: '/',
      name: 'index',
      redirect: { name: 'Login'}
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/blogs',
      name: 'Blogs',
      component: Blogs
    },
    {
      path: '/blogs/add',
      name: 'BlogAdd',
      component: BlogEdit,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/blog/:id',
      name: 'BlogDetail',
      component: BlogDetail
    },
    {
      path: '/blog/:id/edit',
      name: 'BlogEdit',
      component: BlogEdit,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    }
  ]

process.env.BASE_URL = "http://localhost:8081"
const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: routes
})

// router.beforeEach((to, from, next) => {
//   if (!localStorage.getItem("token")) {
//     next({name:"Login"})
//   } else {
//     next()
//   }
// })

export default router
