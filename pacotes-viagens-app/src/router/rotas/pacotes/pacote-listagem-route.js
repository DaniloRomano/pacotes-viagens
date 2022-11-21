import PacotesListagemView from '@/views/pacotes/PacotesListagemView'

export default {
    name: 'pacote-listagem',
    path: '/pacotes',
    component: PacotesListagemView,
    meta: {
        requiresAuth: true
    }
}