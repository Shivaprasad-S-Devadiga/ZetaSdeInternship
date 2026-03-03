
<template>
  <h2>Enterprise Dashboard</h2>
  <p>Total Books: {{ books.length }}</p>
</template>

<script>
export default {
  computed: {
    books() {
      return this.$store.state.books
    }
  },
  mounted() {
    this.$store.dispatch('fetchBooks')
  }
}
</script>
