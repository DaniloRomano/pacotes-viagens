<template>
    <v-container>
        <v-row>
            <v-col cols="12">
                <h4>Cadastro de Destinos</h4>
            </v-col>
            <v-col cols="12">
                <v-textfield v-model="nome" variant="outlined" required />
            </v-col>
            <v-col cols="12">
                <v-btn size="x-large" block >Salvar</v-btn>
            </v-col>
        </v-row>
    </v-container>
</template>
<script>
export default {
    name: 'DestinoNovoView',
    data(){
        return {
            nome: null
        }
    },
}
</script>
