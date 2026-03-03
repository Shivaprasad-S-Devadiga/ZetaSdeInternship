
<template>
  <h2>Books Management</h2>
  <input v-focus v-model="title" placeholder="Title"/>
  <input v-model="author" placeholder="Author"/>
  <button @click="add">Add</button>

  <ul>
    <li v-for="book in books" :key="book.id">
      {{ book.title }} - {{ book.author }}
    </li>
  </ul>
</template>

<script>
export default {
  data() {
    return { title: '', author: '' }
  },
  computed: {
    books() {
      return this.$store.state.books
    }
  },
  methods: {
    add() {
      this.$store.dispatch('addBook', {
        title: this.title,
        author: this.author,
        available: true
      })
      this.title = ''
      this.author = ''
    }
  },
  mounted() {
    this.$store.dispatch('fetchBooks')
  }
}
</script>
