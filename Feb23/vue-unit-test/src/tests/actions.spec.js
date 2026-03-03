import axios from 'axios'
import MockAdapter from 'axios-mock-adapter'
import store from '../store'
import { describe, it, expect } from 'vitest'
import api from '../services/api'

const mock = new MockAdapter(api)

describe('Vuex Actions', () => {

  it('fetchBooks commits SET_BOOKS', async () => {

    const fakeBooks = [{ id: 1, title: 'Mocked Book' }]
    mock.onGet('http://localhost:3000/books')
        .reply(200, fakeBooks)

    await store.dispatch('fetchBooks')

    expect(store.state.books).toEqual(fakeBooks)
  })

})