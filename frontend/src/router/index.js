import { createRouter, createWebHistory } from 'vue-router'
//import HomeView from '../components/HomeView.vue'
import AboutView from '../components/AboutView.vue'
import LoginPage from '../components/auth/LoginPage.vue'
import SignupPage from '../components/auth/SignupPage.vue'

const routes = [
    {
        path: '/',
        redirect: () => {
          // 예: 로컬스토리지에 토큰 있으면 dashboard, 없으면 login
          //return localStorage.getItem('token') ? '/dashboard' : '/login'
          return '/mew/login'
        }
      },
    { path: '/about', component: AboutView },
    { path: '/mew/login', component: LoginPage},
    { path: '/mew/signup', component: SignupPage}
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

router.beforeEach((to, from, next) => {
    const defaultTitle = 'MEW'
    document.title = defaultTitle
    next()
})

export default router