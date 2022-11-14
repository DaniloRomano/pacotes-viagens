import {createApp} from 'vue'
import App from './App.vue'
import router from './router'

// vuetify
import 'vuetify/styles'
import {createVuetify} from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'

import '@mdi/font/css/materialdesignicons.css'
import {aliases, mdi} from 'vuetify/iconsets/mdi'

const travelThemeDefinition = {
    dark: false,
    colors: {
        background: '#EEEEEE',
        surface: '#FFFFFF',
        primary: '#6200EE',
        'primary-darken-1': '#3700B3',
        secondary: '#03DAC6',
        'secondary-darken-1': '#018786',
        error: '#B00020',
        info: '#2196F3',
        success: '#4CAF50',
        warning: '#FB8C00',
    }
}

const vuetify = createVuetify({
    components,
    directives,
    icons: {
        defaultSet: 'mdi',
        aliases,
        sets: {
            mdi,
        }
    },
    theme: {
        defaultTheme: 'travelThemeDefinition',
        themes: {
            travelThemeDefinition
        }
    }
})

const app = createApp(App)

app.use(vuetify)
app.use(router)

app.mount('#app')
