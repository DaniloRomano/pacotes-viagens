<template>
  <v-container>
    <v-row>
      <v-col cols="2">
        <v-btn variant="text" size="x-large" to="/destino/novo" prepend-icon="mdi-plus">Novo</v-btn>
      </v-col>
      <v-col cols="7">
        <v-text-field
          v-model="nome"
          variant="outlined"
          label="Pesquisar por nome"
          clearable
        />
      </v-col>
      <v-col cols="3">
        <v-btn color="primary" @click="buscar()" block size="x-large"
          >Buscar</v-btn
        >
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <v-table fixed-header>
          <thead>
            <tr>
              <th>Código</th>
              <th>Nome</th>
              <th>Ações</th>
            </tr>
          </thead>
          <tbody v-if="destinos">
            <tr v-for="destino in destinos" :key="destino.id">
              <td>{{ destino.id }}</td>
              <td>{{ destino.nome }}</td>
              <td>
                <v-btn icon="mdi-pencil" size="small" @click="irParaEdicao(destino.id)" variant="icon"></v-btn>
                <v-btn icon="mdi-delete" size="small" @click="deletarDestino(destino.id)" variant="icon" color="red"></v-btn>
              </td>
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
      <v-col cols="12">
        <v-pagination v-model="page" :length="totalPages" @click="carregarPagina()"></v-pagination>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
import DestinoService from "@/services/destino/DestinoService";

export default {
  name: "DestinoListagemView",
  data() {
    return {
      destinos: null,
      nome: null,
      page: 1,
      totalPages: 1
    };
  },
  methods: {
    carregarPagina(){
      DestinoService.getAllByFilter({nome: this.nome, page: this.page-1})
        .then((response) => {
          this.destinos = response.data.content
          this.totalPages = response.data.totalPages
        })
        .catch((error) => {
          console.log(error);
        });
    },
    buscar() {
      DestinoService.getAllByFilter({nome: this.nome, page: 0})
        .then((response) => {
          this.destinos = response.data.content
          this.totalPages = response.data.totalPages
        })
        .catch((error) => {
          console.log(error);
        });
    },
    irParaEdicao(idDestino){
      
    },
    deletarDestino(idDestino){

    }
  },
  mounted() {
    this.buscar();
  },
};
</script>
