
import { createRouter, createWebHistory } from 'vue-router'
import store from '../store'

import Dashboard from '../views/Dashboard.vue'
import Books from '../views/Books.vue'
import Login from '../views/Login.vue'

const routes = [
  { path: '/', component: Dashboard },
  { path: '/login', component: Login },
  { path: '/books', component: Books, meta: { requiresAuth: false } }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  if (to.meta.requiresAuth && !store.getters.isAuthenticated) {
    next('/login')
  } else {
    next()
  }
})

export default router
