import {createRouter, createWebHashHistory} from 'vue-router'
import {login, home,destinoListagem,destinoNovo } from './rotas'
import userService from '@/services/user/UserService'

const routes = [
    home,
    login,
    destinoListagem,
    destinoNovo
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

router.beforeEach(async (to, from, next) => {
    const user = userService.getSelectedUser()
    if (to.matched.some((record) => record.meta.requiresAuth)) {
        if (!user) {
            next({name: 'login'})
        } else {
            next()
        }
    } else {
        next()
    }
})

export default router
