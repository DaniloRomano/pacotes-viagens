import LoginView from "@/views/login/LoginView";

export default{
    path: '/login',
    name: 'login',
    component: LoginView,
    meta: {
        requiresAuth: false
    }
}