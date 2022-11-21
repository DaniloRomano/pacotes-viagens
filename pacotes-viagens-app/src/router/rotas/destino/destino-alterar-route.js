import DestinoAlterarView from '@/views/destino/DestinoAlterarView'
export default {
    path: '/destino/:id',
    name: 'destino-alterar',
    component: DestinoAlterarView,
    meta: {
        requiresAuth: true
    }
}