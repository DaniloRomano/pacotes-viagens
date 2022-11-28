import api from '@/plugins/api'
import {storageKeys} from '@/constants'

class ViajanteService {
    async login(viajanteModel) {
        const response = await api.post('/viajante/login', viajanteModel)
        if (response.status === 200) {
            if (response.data.id > 0)
                localStorage.setItem(storageKeys.VIAJANTE_KEY, response.data.id)
            return true
        }
        return false
    }

    async getById(id) {
        return await api.get(`/viajante/${id}`)
    }

    async inserir(viajante) {
        return await api.post('/viajante', viajante)
    }

    getViajanteLogado() {
        return localStorage.getItem(storageKeys.VIAJANTE_KEY)
    }
}

export default new ViajanteService()