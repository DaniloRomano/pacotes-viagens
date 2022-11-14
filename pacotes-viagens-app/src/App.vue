<template>
  <v-app v-if="this.$route.meta.requiresAuth===false">
    <login-view/>
  </v-app>
  <v-app v-else>
    <core-view/>
  </v-app>
</template>

<script>
import LoginView from '@/views/login/LoginView'
import CoreView from "@/components/CoreView";

export default {
  components: {
    CoreView,
    LoginView
  },
}
</script>