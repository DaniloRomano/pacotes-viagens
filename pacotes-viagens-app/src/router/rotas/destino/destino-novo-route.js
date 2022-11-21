import DestinoNovoView from '@/views/destino/DestinoNovoView'
export default {
    path: '/destino/novo',
    name: 'destino-novo',
    component: DestinoNovoView,
    meta: {
        requiresAuth: true
    }
}