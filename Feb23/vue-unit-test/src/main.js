
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import focus from './directives/focus'

const app = createApp(App)
app.use(store)
app.use(router)
app.directive('focus', focus)
app.mount('#app')
