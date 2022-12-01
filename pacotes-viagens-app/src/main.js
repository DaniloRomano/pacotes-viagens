import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from '@/plugins/vuetify'
import vuex from '@/plugins/vuex'

const app = createApp(App)

app.use(vuetify)
app.use(router)
app.use(vuex)

app.mount('#app')
