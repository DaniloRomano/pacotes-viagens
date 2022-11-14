import api from '@/plugins/api'

class DestinoService{
    getAll(){
        return api.get('/destino');
    }
}

export default new DestinoService()