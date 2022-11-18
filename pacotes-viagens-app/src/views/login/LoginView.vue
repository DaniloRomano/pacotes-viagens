<template>
  <div class="login-page">
    <div class="left-container">
      <img src="../../assets/logo-travel.png"/>
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
          <v-col cols="6">
            <v-btn
                prepend-icon="mdi-account-multiple"
                variant="outlined"
                stacked                
                color="primary"
                class="mb-5"
                @click="setCustomerUser()">Acessar como Cliente
            </v-btn>
          </v-col>
          <v-col cols="6">
            <v-btn
                prepend-icon="mdi-account"
                variant="outlined"                
                stacked
                color="secondary"
                @click="setAdministratorUser()">Acessar como Adiministrador
            </v-btn>
          </v-col>
        </v-row>
      </v-container>

    </div>
  </div>
</template>
<script>
import userService from '@/services/user/UserService'

export default {
  methods: {
    setCustomerUser() {
      userService.setUserCustomer()
      this.redirectToHome()
    },
    setAdministratorUser() {
      userService.setUserAdministrator();
      this.redirectToHome()
    },
    redirectToHome() {      
      setTimeout(()=>this.$router.push({name: 'home'}),500)
    }
  }
}
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
  background: url('../../assets/estrutura/login-page-background.jpg') #920605 no-repeat;
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
  padding: 10em 2em;
  text-align: center;
}
</style>
