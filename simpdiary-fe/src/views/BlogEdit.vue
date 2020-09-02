<template>
  <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="Title">
      <el-input v-model="form.title"></el-input>
    </el-form-item>
    <el-form-item label="Description">
      <el-input v-model="form.description"></el-input>
    </el-form-item>
    <el-form-item label="Conetent">
      <mavon-editor v-model="form.content" language="en"/>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">Publish</el-button>
      <el-button @click="$router.push('/blogs')">Cancel</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  name: "BlogEdit",
  data() {
    return {
      form: {
        content: "",
        title: "",
        description:"",
        id: ""
      },
      id: ""
    }
  },
  methods: {
    onSubmit() {
      this.$axios.put("http://localhost:8080/blog/edit", this.form, {
        headers: {
          "Authorization": localStorage.getItem("token")
        }
      }).then((res) => {
        console.log(res);
      })
    }
  }
}
</script>

<style scoped>
</style>
