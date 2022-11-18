import HomeView from "@/views/HomeView";

export default {
    path: '/',
    name: 'home',
    component: HomeView,
    meta:{
        requiresAuth: true
    }
}