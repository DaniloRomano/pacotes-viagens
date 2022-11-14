<template>
  <v-container>
    <v-row>
      Filtro
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
          <tr v-repeat="destino in destinos.content" :key="destino.id"> {{destinos}}
            <td>destino.id</td>
            <td>destino.nome</td>
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
      destinos: null
    }
  },
  methods: {
    carregarDestinos() {
      DestinoService.getAll().then((response) => {
            let retorno=Object.freeze(response.data)
            this.destinos = retorno
          }
      ).catch((error) => {
            console.log(error)
          }
      )
    }
  }
  ,
  mounted() {
    this.carregarDestinos();
  }
}
</script>