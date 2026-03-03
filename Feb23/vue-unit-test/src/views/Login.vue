
<template>
  <h2>Login</h2>
  <form @submit.prevent="login">
    <input v-model="email" placeholder="Email"/>
    <input v-model="password" type="password" placeholder="Password"/>
    <button>Login</button>
  </form>
  <p v-if="error" style="color:red">{{ error }}</p>
</template>

<script>
export default {
  data() {
    return { email: '', password: '', error: '' }
  },
  methods: {
    async login() {
      const ok = await this.$store.dispatch('login', {
        email: this.email,
        password: this.password
      })
      if (ok) this.$router.push('/books')
      else this.error = 'Invalid credentials'
    }
  }
}
</script>
