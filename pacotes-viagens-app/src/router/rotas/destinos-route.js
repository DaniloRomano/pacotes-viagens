import DestinoListagemView from '@/views/destino/DestinoListagemView'

export default {
    path: '/destino/',
    name: 'destino',
    component: DestinoListagemView,
    meta: {
        requiresAuth: true
    }
}