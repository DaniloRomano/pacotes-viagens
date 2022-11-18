import api from '@/plugins/api'

class DestinoService {
    getAll() {
        return api.get('/destino')
    }

    async getAllByFilter(filters) {
        if (filters.nome)
            return await api.get(`/destino?nome=${filters.nome}&page=${filters.page}`)
        return await api.get(`/destino?page=${filters.page}`)
    }

    async getById(id){
        const retorno = await api.get(`/destino/${id}`)
        return retorno
    }

    deletar(id){
        api.delete(`/destino/${id}`)
    }

    alterar(destino){
        return api.put(`/destino/${destino.id}`,destino)
    }

    async inserir(destino){
        const retorno = await api.post('/destino',destino)
        return retorno;
    }
}

export default new DestinoService()