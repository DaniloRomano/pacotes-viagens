<template>
  <v-navigation-drawer theme="dark" app>
    <v-list>
      <v-list-item
          :prepend-avatar="getAvatar()"
          :title="name">
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
      <v-list-item nav to="/pacotes" prepend-icon="mdi-map-plus" v-if="isAdmin()">
        Pacotes
      </v-list-item>
      <v-list-item nav to="/encontrar-pacote" prepend-icon="mdi-map-search" v-if="isCustomer()">
        Encontrar Pacote
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>
<script>
import userService from '@/services/user/UserService'
import viajanteService from "@/services/viajante/ViajanteService";
import {userTypes, storageKeys} from '@/constants'

export default {
  name: 'MenuDeNavegacao',
  data() {
    return {
      userName: null,
      name: 'NOME'
    }
  },
  methods: {
    isAdmin() {
      return this.userName === userTypes.ADMINISTRATOR
    },
    isCustomer() {
      return this.userName === userTypes.CUSTOMER
    },
    getAvatar() {
      if (this.isCustomer()) {
        return 'https://randomuser.me/api/portraits/women/68.jpg'
      } else
        return 'https://randomuser.me/api/portraits/men/88.jpg'
    },
    deslogar() {
      userService.logoutUser();
      setTimeout(() => window.location.reload(), 300);
    },
    async setNameUsuario() {
      let userIdLogado = viajanteService.getViajanteLogado()
      if (userIdLogado) {
        let {status, data} = await viajanteService.getById(userIdLogado)
        if (status === 200) {
          this.name = data.nome
        }
      } else {
        this.name = 'ERROR'
      }
    }
  },
  async mounted() {
    this.userName = userService.getSelectedUser()
    if (this.isCustomer())
      await this.setNameUsuario()
    else
      this.name=this.userName;
  },
}
</script>