import api from '@/plugins/api'

class DestinoService {
    getAll() {
        return api.get('/destino')
    }

    getAllByFilter(nome) {
        if (nome)
            return api.get(`/destino?nome=${nome}`)
        return api.get('/destino')
    }
}

export default new DestinoService()