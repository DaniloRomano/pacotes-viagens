import EncontrePacotesView from '@/views/encontrar-pacotes/EncontrarPacotesView'

export default{
    path: '/encontre-pacotes',
    name: 'encontre-pacotes',
    component: EncontrePacotesView,
    meta: {
        requiresAuth: true
    }
}