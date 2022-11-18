<template>
  <v-app>
    <app-bar-principal />
    <menu-de-navegacao />
    <v-main>
      <div class="conteudo">
        <alerta-padrao></alerta-padrao>
        <router-view />
      </div>
    </v-main>    
  </v-app>
</template>
<script>
import MenuDeNavegacao from "@/components/MenuDeNavegacao";
import AppBarPrincipal from "@/components/AppBarPrincipal";
import AlertaPadrao from './alerta/AlertaPadrao.vue';

export default {
  components: {
    AppBarPrincipal,
    MenuDeNavegacao,
    AlertaPadrao,
  },
  name: "CoreView",
};
</script>
<style>
.conteudo {
  padding: 30px;
}
</style>
