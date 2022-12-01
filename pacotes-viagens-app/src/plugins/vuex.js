import {createStore} from 'vuex'
import {alerta} from '@/store'

const store = createStore({
    modules:{
        alerta
    }
})

export default store;