<template>
  <div class="login-page">
    <div class="left-container">
      <img src="../../assets/logo-travel.png" alt="Logotipo"/>
    </div>
    <div class="right-container">
      <v-container fluid>
        <v-row>
          <v-col cols="12">
            <h1>UFMS Travel</h1>
          </v-col>
          <v-col cols="12">
            <h4>Venda de pacotes de Viagem</h4>
          </v-col>
          <v-divider class="my-10"></v-divider>
          <v-col cols="12" v-if="exibeLoginCliente">
            <v-text-field variant="outlined" label="Usuário" placeholder="Digite o seu nome de usuário" v-model="user"/>
            <v-text-field variant="outlined" type="password" label="Senha" placeholder="Digite a sua senha"
                          v-model="senha"/>
            <v-btn variant="elevated" block color="green" prepend-icon="mdi-access" @click="entrar()">Entrar</v-btn>
            <v-btn variant="elevated" class="mt-5" block color="primary" prepend-icon="mdi-plus"
                   @click="toggleCadastroVisitanteDialog()">Cadastrar-se
            </v-btn>
            <v-btn variant="elevated" block class="mt-5" color="red" prepend-icon="mdi-cancel"
                   @click="setExibirLoginCliente(false)">Voltar
            </v-btn>
          </v-col>
          <v-col cols="12" v-else>
            <v-btn
                prepend-icon="mdi-account-multiple"
                variant="elevated"
                color="primary"
                block
                class="mb-5"
                @click="setExibirLoginCliente(true)"
            >Acessar como Cliente
            </v-btn>
            <v-btn
                prepend-icon="mdi-account"
                variant="elevated"
                block
                color="secondary"
                @click="setAdministratorUser()"
            >Acessar como Adiministrador
            </v-btn>
          </v-col>
        </v-row>
      </v-container>
    </div>
  </div>
  <v-row justify="center">
    <v-dialog v-model="dialog" fullscreen :scrim="false" transition="dialog-bottom-transition">
      <v-card>
        <v-toolbar color="primary" dark density="compact">
          <v-btn icon dark color="white" @click="toggleCadastroVisitanteDialog">
            <v-icon>mdi-close</v-icon>
          </v-btn>
        </v-toolbar>
        <v-card-text>
          <cadastro-viajante-view v-on:fechar="toggleCadastroVisitanteDialog()"/>
        </v-card-text>
      </v-card>
    </v-dialog>
  </v-row>
</template>
<script>
import userService from "@/services/user/UserService";
import viajanteService from '@/services/viajante/ViajanteService'
import CadastroViajanteView from "@/views/viajante/CadastroViajanteView";
import ViajanteModel from '@/models/viajante/ViajanteModel'

export default {
  components:{
    CadastroViajanteView
  },
  data() {
    return {
      exibeLoginCliente: false,
      dialog: false,
      user: null,
      senha: null,
    }
  },
  methods: {
    toggleCadastroVisitanteDialog() {
      this.dialog = !this.dialog;
    },
    setExibirLoginCliente(valor) {
      this.exibeLoginCliente = valor
    },
    async entrar() {
      let loginInfo = new ViajanteModel();
      loginInfo.password = this.senha
      loginInfo.cpf = this.user
      let retorno = viajanteService.login(loginInfo)
      if (retorno) {
        this.setCustomerUser()
      } else {
        alert("Usuário ou senha inválidos.")
      }
    }
    ,
    setCustomerUser() {
      userService.setUserCustomer();
      this.redirectToHome();
    },
    setAdministratorUser() {
      userService.setUserAdministrator();
      this.redirectToHome();
    },
    redirectToHome() {
      setTimeout(() => this.$router.push({name: "home"}), 500);
    },
  },
};
</script>

<style scoped>
.login-page {
  height: 100vh;
  display: flex;
  flex-direction: row;
  width: 100%;
}

.left-container {
  width: 65%;
  background: url("../../assets/estrutura/login-page-background.jpg") #920605 no-repeat;
  background-size: cover;
  background-position-x: -45rem;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-content: center;
  align-items: center;
}

.left-container img {
  width: 50%;
}

.right-container {
  width: 35%;
  padding: 5em 2em;
  text-align: center;
}
</style>
