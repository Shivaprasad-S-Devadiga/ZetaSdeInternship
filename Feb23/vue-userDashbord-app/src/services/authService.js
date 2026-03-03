import axios from 'axios'

const api = axios.create({
  baseURL: 'http://localhost:3000'
})

export default {

  async login(email, password) {
    const response = await api.get('/users', {
      params: { email, password }
    })

    if (response.data.length > 0) {
      const user = response.data[0]
      const fakeToken = "fake-jwt-token"

      localStorage.setItem("user", JSON.stringify(user))
      localStorage.setItem("token", fakeToken)

      return user
    } else {
      throw new Error("Invalid credentials")
    }
  },

  async register(user) {
    return api.post('/users', user)
  },

  logout() {
    localStorage.removeItem("user")
    localStorage.removeItem("token")
  },

  getCurrentUser() {
    return JSON.parse(localStorage.getItem("user"))
  },

  isAuthenticated() {
    return !!localStorage.getItem("token")
  }
}

api.interceptors.request.use(config => {
  const token = localStorage.getItem("token")
  if (token) {
    config.headers.Authorization = `Bearer ${token}`
  }
  return config
})

