import Vue from 'vue'
import Router from 'vue-router'
import BlogDetail from '../views/BlogDetail'
import Login from '../views/Login'
import BlogEdit from '../views/BlogEdit'
import Blogs from '../views/Blogs'


Vue.use(Router)

export default new Router({
  routes: [
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
      path: '/blog/add',
      name: 'BlogAdd',
      component: BlogEdit
    },
    {
      path: '/blog/:id',
      name: 'BlogDetail',
      component: BlogDetaial
    },
    {
      path: '/blog/:id/edit',
      name: 'BlogEdit',
      component: BlogEdit,
      meta: {
        requireAuth: true
      }
    }
  ]
})
