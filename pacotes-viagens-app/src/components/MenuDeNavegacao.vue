<template>
  <v-navigation-drawer theme="dark" app>
    <v-list>
      <v-list-item
      :prepend-avatar="getAvatar()"
      :title="userName">
        <v-btn variant="plain" v-on:click="deslogar()">Sair</v-btn>
      </v-list-item>
      <v-divider/>
      <v-list-item nav to="/" prepend-icon="mdi-home">
        Home
      </v-list-item>
      <v-list-item nav to="/destino" prepend-icon="mdi-wallet-travel" v-if="isAdmin()">
        Destino
      </v-list-item>
      <v-list-item nav to="/minhas-compras" prepend-icon="mdi-cart" v-if="isCustomer()">
        Minhas Compras
      </v-list-item>
      <v-list-item nav to="/pacotes" prepend-icon="mdi-tool" v-if="isAdmin()">
        Pacotes
      </v-list-item>
      <v-list-item nav to="/encontrar-pacote" prepend-icon="mdi-find" v-if="isCustomer()">
        Encontrar Pacote
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>
<script>
import userService from '@/services/user/UserService'
import { userTypes } from '@/constants'

export default{
  name: 'MenuDeNavegacao',
  data(){
    return {
      userName: null
    }
  },
  methods:{
    isAdmin(){
      return this.userName === userTypes.ADMINISTRATOR
    },
    isCustomer(){
      return this.userName === userTypes.CUSTOMER
    },
    getAvatar(){
      if (this.isCustomer())
        return 'https://randomuser.me/api/portraits/women/90.jpg'
      else
        return 'https://randomuser.me/api/portraits/men/88.jpg'
    },
    deslogar(){
      userService.logoutUser();
      setTimeout(()=> window.location.reload(),300);
    }
  },
  mounted(){
    this.userName = userService.getSelectedUser()
  },
}
</script>