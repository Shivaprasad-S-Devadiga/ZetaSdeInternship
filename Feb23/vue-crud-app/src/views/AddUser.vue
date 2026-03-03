<template>
  <h2>Add User</h2>

  <input v-model="name" placeholder="Name" />
  <input v-model="email" placeholder="Email" />

  <div>
    <label>
      <input type="radio" name="gender" value="Male" v-model="gender" />
      Male
    </label>

    <label>
      <input type="radio" name="gender" value="Female" v-model="gender" />
      Female
    </label>
  </div>

  <h4>Skills</h4>
  <div>
    <label>
      <input type="checkbox" value="Java" v-model="skills" />
      Java
    </label>

    <label>
      <input type="checkbox" value="Design Pattern" v-model="skills" />
      Design Pattern
    </label>

    <label>
      <input type="checkbox" value="VueJS" v-model="skills" />
      VueJS
    </label>

    <label>
      <input type="checkbox" value="SpringBoot" v-model="skills" />
      SpringBoot
    </label>
  </div>

  <button @click="saveUser">Save</button>
</template>

<script>
import api from '../services/api'

export default {
  data() {
    return {
      name: '',
      email: '',
      gender: '',     
      skills: []      
    }
  },
  methods: {
    saveUser() {
      api.addUser({
        name: this.name,
        email: this.email,
        gender: this.gender,   
        skills: this.skills    
      }).then(() => {
        this.$router.push('/users')
      })
    }
  }
}
</script>