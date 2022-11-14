<template>
  <v-app>
    <app-bar-principal />
    <menu-de-navegacao />
    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>
<script>
import MenuDeNavegacao from '@/components/MenuDeNavegacao'
import AppBarPrincipal from "@/components/AppBarPrincipal";

  export default{
    components:{
      AppBarPrincipal,
      MenuDeNavegacao
    },
    name: 'CoreView'
  }
</script>