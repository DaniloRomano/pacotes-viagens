<template>
  <v-container>
    <v-row>
      <v-col offset="3" cols="6">
        <v-text-field v-model="nome"/>
      </v-col>
      <v-col cols="3">
        <v-btn color="primary" variant="outlined" @click="buscar()" >Buscar</v-btn>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <v-table fixed-header>
          <thead>
          <tr>
            <th>
              Código
            </th>
            <th>
              Nome
            </th>
          </tr>
          </thead>
          <tbody v-if="destinos">
          <tr v-for="destino in destinos" :key="destino.id">
            <td>{{destino.id}}</td>
            <td>{{ destino.nome }}</td>
          </tr>
          </tbody>
          <div v-else>
            <v-row>
              <v-col cols="12">
                <v-card>
                  <v-card-title>NÃO FORAM ENCONTRADOS REGISTROS</v-card-title>
                </v-card>
              </v-col>
            </v-row>
          </div>
        </v-table>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
import DestinoService from '@/services/destino/DestinoService'

export default {
  name: 'DestinoListagemView',
  data(){
    return {
      destinos: null,
      nome: null,
    }
  },
  methods: {
    buscar(){
      DestinoService.getAllByFilter(this.nome).then((response) => {
            this.destinos=response.data.content
          }
      ).catch((error) => {
            console.log(error)
          }
      )
    }
  }
  ,
  mounted() {
    this.buscar();
  }
}
</script>