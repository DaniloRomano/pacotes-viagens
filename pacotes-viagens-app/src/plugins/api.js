import axios from 'axios'

const api = axios.create({
    baseURL: 'http://localhost:8081/v1',
})

export default api