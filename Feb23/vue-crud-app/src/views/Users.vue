<template>
  <h2>Users</h2>

  <table border="1" cellpadding="8" cellspacing="0">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Skills</th>
        <th>Actions</th>
      </tr>
    </thead>

    <tbody>
      <tr v-for="user in users" :key="user.id">
        <td>{{ user.id }}</td>
        <td>{{ user.name }}</td>
        <td>{{ user.email }}</td>
        <td>{{ user.gender }}</td>

        <td>
          <ul v-if="user.skills && user.skills.length">
            <li v-for="(skill, index) in user.skills" :key="index">
              {{ skill }}
            </li>
          </ul>
          <span v-else>No skills</span>
        </td>

        <td>
          <button @click="editUser(user.id)">Edit</button>
          <button @click="removeUser(user.id)">Delete</button>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import api from '../services/api'

export default {
  name: 'Users',
  data() {
    return {
      users: [] // ✅ THIS is what your warning says is missing
    }
  },
  mounted() {
    this.loadUsers()
  },
  methods: {
    loadUsers() {
      api.getUsers().then((res) => {
        this.users = res.data
      })
    },
    editUser(id) {
      this.$router.push(`/edit/${id}`)
    },
    removeUser(id) {
      api.deleteUser(id).then(() => {
        this.loadUsers()
      })
    }
  }
}
</script>