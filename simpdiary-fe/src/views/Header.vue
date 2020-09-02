<template>
  <div class="maction">
    <el-link type="success" href="/blogs">Blogs</el-link>
    <el-divider direction="vertical"></el-divider>
    <span>
          <el-link type="success" href="/blogs/add" :disabled="!hasLogin">Publish</el-link>
        </span>
    <el-divider direction="vertical"></el-divider>
    <span v-show="!hasLogin">
          <el-link type="primary" href="/login">Login</el-link>
        </span>
    <span v-show="hasLogin">
          <el-link type="danger" @click="logout">Logout</el-link>
        </span>
  </div>

</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      hasLogin: false
    }
  },
  created() {
    if (this.$store.getters.getUser.username) {
      this.hasLogin = true
    }
  },
  methods: {
    logout() {
      this.$axios.get( "http://localhost:8080/account/logout",
        {headers: {
        "Authorization": localStorage.getItem("token")
      }}).then((res) => {
        this.$store.commit("REMOVE_INFO")
        this.$router.go(0)
      })

    }
  }
}
</script>

<style scoped>
</style>
