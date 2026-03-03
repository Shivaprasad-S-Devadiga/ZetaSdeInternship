import { describe, it, expect } from 'vitest'
import store from '../store'

describe('Vuex Mutations', () => {

  it('SET_BOOKS mutation updates state', () => {
    const books = [{ id: 1, title: 'Test' }]
    store.commit('SET_BOOKS', books)

    expect(store.state.books).toEqual(books)
  })

  it('SET_TOKEN stores token', () => {
    store.commit('SET_TOKEN', 'abc123')

    expect(store.state.token).toBe('abc123')
    expect(localStorage.getItem('token')).toBe('abc123')
  })
it('availableBooks getter works', () => {
  store.state.books = [
    { id: 1, available: true },
    { id: 2, available: false }
  ]

  const result = store.getters.availableBooks
  expect(result.length).toBe(1)
})
})