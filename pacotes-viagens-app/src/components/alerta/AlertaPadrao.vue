<template>
  <v-alert
    :title="title"
    :text="mensagem"
    :type="tipo"
    v-model="showAlerta"
    @show-alerta-sucesso="showAlertaSucesso"
    class="alerta"
  ></v-alert>
</template>
<script>
import { alerta } from '@/constants'

export default {
  name: "AlertaPadrao",  
  data() {
    return {
        title: alerta.TITULO.SUCESSO,
        mensagem: 'Ação realizada com sucesso!',
        tipo: alerta.TIPO.SUCESSO,
        showAlerta: false
    }
  },
  methods:{
    showAlertaSucesso(mensagem){
        this.mensagem=mensagem
        this.setTipoAlerta(alerta.TIPO.SUCESSO)
        this.showAlerta=true
        setTimeout(()=> this.showAlerta=false,alerta.CONFIGURACAO.TIMEOUT)
    },
    showAlertaErro(mensagem){
        this.mensagem=mensagem
        this.setTipoAlerta(alerta.TIPO.ERRO)
        this.showAlerta=true
        setTimeout(()=> this.showAlerta=false,alerta.CONFIGURACAO.TIMEOUT)
    },
    setTipoAlerta(tipo){
        switch(tipo){
            case alerta.TIPO.SUCESSO: 
                this.titulo = alerta.TITULO.SUCESSO
                this.tipo = alerta.TIPO.SUCESSO
                break
            case alerta.TIPO.ERRO:
                this.titulo = alerta.TITULO.ERRO
                this.tipo = alerta.TIPO.ERRO
                brek
        }
    }
  }
};
</script>
<style scoped>
.alerta {
  position: fixed;
  right: 10px;
  top: 20px;
  z-index: 9999;
}
</style>
