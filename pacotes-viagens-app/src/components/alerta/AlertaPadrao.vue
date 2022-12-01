<template>
  <v-alert
      title="Alerta"
      :text="alerta.msg"
      :type="alerta.tipo"
      v-model="alerta.mostrar"
      class="alerta"
  ></v-alert>
</template>
<script>
import {mapState} from 'vuex'

export default {
  name: "AlertaPadrao",
  computed: {
    ...mapState(["alerta"])
  }
}
</script>
<style scoped>
.alerta {
  position: fixed;
  right: 10px;
  top: 20px;
  z-index: 9999;
}
</style>
