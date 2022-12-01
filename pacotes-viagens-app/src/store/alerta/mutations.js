import { mutationTypes} from './../../constants'

export default {
    [mutationTypes.ALERTA.SHOW_ALERTA](state, dados){
        state.msg= dados.msg
        state.tipo=dados.tipo
        state.mostrar = dados.mostrar

        setTimeout(()=>{
            state.msg=''
            state.mostrar=false
        },4000)
    }
}