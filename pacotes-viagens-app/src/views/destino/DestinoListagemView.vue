<template>
  <v-container>    
    <v-row>
      <v-col cols="2">
        <v-btn
          variant="text"
          size="x-large"
          to="/destino/novo"
          prepend-icon="mdi-plus"
          >Novo</v-btn
        >
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
        <v-progress-linear color="primary" indeterminate block v-if="loading"></v-progress-linear>
        <v-table>
          <thead>
            <tr>
              <th>Código</th>
              <th>Nome</th>
              <th>Ações</th>
            </tr>
          </thead>                    
          <tbody v-if="totalElementos > 0">
            <tr v-for="destino in destinos" :key="destino.id">
              <td>{{ destino.id }}</td>
              <td>{{ destino.nome }}</td>
              <td>
                <v-btn
                  icon="mdi-pencil"
                  size="small"
                  @click="irParaEdicao(destino.id)"
                  variant="icon"
                ></v-btn>
                <v-btn
                  icon="mdi-delete"
                  size="small"
                  @click="deletarDestino(destino.id)"
                  variant="icon"
                  color="red"
                ></v-btn>
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
        <v-pagination
          v-model="page"
          total-visible="5"
          :length="totalPaginas"
          @click="carregarPagina()"
        ></v-pagination>
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
      nome: null,
      page: 1,
      destinos: null,
      totalPaginas: 0,
      totalElementos: 0,
      loading: false
    };
  },
  methods: {
    async carregarPagina(page) {
      this.loading=true
      let retorno = await DestinoService.getAllByFilter({
        nome: this.nome,
        page: this.page - 1,
      });
      if (retorno.status == 200) {
        this.destinos = retorno.data.content;
        this.totalPaginas = retorno.data.totalPages;
        this.totalElementos = retorno.data.totalElements;
      } else {
        alert("Ocorreu um erro");
      }
      this.loading=false
    },
    async buscar() {
      this.loading=true
      let retorno = await DestinoService.getAllByFilter({
        nome: this.nome,
        page: 0,
      });
      if (retorno.status == 200) {
        this.destinos = retorno.data.content;
        this.totalPaginas = retorno.data.totalPages;
        this.totalElementos = retorno.data.totalElements;
      } else {
        alert("Ocorreu um erro");
      }
      this.loading=false
    },
    irParaEdicao(idDestino) {
      this.$router.push({name: 'destino-alterar', params:{id:idDestino}})
    },
    async deletarDestino(idDestino) {
      await DestinoService.deletar(idDestino);
      alert("Excluido com sucesso");
      await this.buscar();
    },
  },
  async mounted() {
    await this.buscar();
  },
};
</script>
