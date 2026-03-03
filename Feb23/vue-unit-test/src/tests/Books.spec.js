import { mount } from '@vue/test-utils'
import { createStore } from 'vuex'
import Books from '../views/Books.vue'
import { describe, it, expect } from 'vitest'

describe('Books Component', () => {

  it('renders books from store', () => {

    const store = createStore({
      state() {
        return {
          books: [{ id: 1, title: 'Test Book', author: 'A' }]
        }
      }
    })

    const wrapper = mount(Books, {
      global: {
        plugins: [store]
      }
    })

    expect(wrapper.text()).toContain('Test Book')
  }),

  it('renders all books from store', () => {

  const store = createStore({
    state: () => ({
      books: [
        { id: 1, title: 'Vue', author: 'A' },
        { id: 2, title: 'React', author: 'B' },
        { id: 3, title:'JS' , author:'c'}
      ]
    }),
    //actions: { fetchBooks: () => {} }
  })

  const wrapper = mount(Books, {
    global: { plugins: [store] }
  })

  expect(wrapper.findAll('li')).toHaveLength(2)
})

})