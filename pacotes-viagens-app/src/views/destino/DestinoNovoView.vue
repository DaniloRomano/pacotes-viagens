<template>
    <v-container>
        <v-row>
            <v-col cols="12">
                <h4>Cadastro de Destinos</h4>
            </v-col>
            <v-col cols="6">
                <v-text-field label="Nome" v-model="destino.nome" placeholder="Digite o nome do destino" variant="outlined"></v-text-field>
            </v-col>
            <v-col cols="6">
                <v-btn size="x-large" block @click="salvar()">Salvar</v-btn>
            </v-col>
        </v-row>
    </v-container>
</template>
<script>
import DestinoModel from '@/models/destino/DestinoModel'
import DestinoService from '@/services/destino/DestinoService'

export default {
    name: 'DestinoNovoView',
    data(){
        return {
            destino: DestinoModel
        }
    },
    methods:{
        async salvar(){
            let response = await DestinoService.inserir(this.destino)            
            if (response.status===200){   
                this.destino.nome=null
                alert('salvo com sucesso')                
                this.$router.push({name: 'destino'})
            }else{
                alert('Ocorreu um erro: '+response.status)
            }
        }
    }
}
</script>
