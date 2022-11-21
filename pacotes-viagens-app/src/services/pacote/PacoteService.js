import api from '@/plugins/api'

class PacoteService{
    async getAllByFilter(filtro){
        const retorno = await api.get('/pacotes')
        return retorno
    }
}