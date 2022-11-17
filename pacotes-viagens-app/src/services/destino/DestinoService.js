import api from '@/plugins/api'

class DestinoService {
    getAll() {
        return api.get('/destino')
    }

    getAllByFilter(filters) {
        if (filters.nome)
            return api.get(`/destino?nome=${filters.nome}&page=${filters.page}`)
        return api.get(`/destino?page=${filters.page}`)
    }

    deletar(id){
        api.delete(`/destino/${id}`)
    }

    alterar(destino){
        return api.put(`/destino/${id}`,destino)
    }
}

export default new DestinoService()