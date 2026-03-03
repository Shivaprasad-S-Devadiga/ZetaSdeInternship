
import { createStore } from 'vuex'
import api from '../services/api'

export default createStore({
  state: {
    books: [],
    token: localStorage.getItem('token') || null
  },

  getters: {
    isAuthenticated: state => !!state.token,
    availableBooks: state => state.books.filter(b => b.available)
  },

  mutations: {
    SET_BOOKS(state, books) { state.books = books },
    ADD_BOOK(state, book) { state.books.push(book) },
    SET_TOKEN(state, token) {
      state.token = token
      localStorage.setItem('token', token)
    },
    LOGOUT(state) {
      state.token = null
      localStorage.removeItem('token')
    }
  },

  actions: {
    async fetchBooks({ commit }) {
      const res = await api.get('/books')
      commit('SET_BOOKS', res.data)
    },
    async addBook({ commit }, book) {
      const res = await api.post('/books', book)
      commit('ADD_BOOK', res.data)
    },
    login({ commit }, creds) {
      if (creds.email === 'admin@test.com' && creds.password === '1234') {
        commit('SET_TOKEN', 'enterprise-token')
        return true
      }
      return false
    },
    logout({ commit }) {
      commit('LOGOUT')
    }
  }
})
