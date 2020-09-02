<template>
  <el-form ref="form" :model="form" label-width="80px">
    <el-form-item label="Username">
      <el-input v-model="form.username"></el-input>
    </el-form-item>
    <el-form-item label="Password">
      <el-input v-model="form.password"></el-input>
    </el-form-item>
    <el-form-item label="Email">
      <el-input v-model="form.email"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">Create</el-button>
      <el-button @click="$router.go(-1)">Cancel</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import Element from "element-ui"
export default {
  name: "Register",
  data() {
    return {
      form: {
        username: '',
        password: '',
        email: ''
      }
    }
  },
  methods: {
    onSubmit() {
      console.log('submit!');
      this.$axios.post('http://localhost:8080/account/register', this.form).then((res) => {
        let data = res.data.data;
        if (data.code === 200) {
          Element.Message.success("注册成功！")
        }
      })
    }
  }
}
</script>

<style scoped>
.el-form-item {
  width: 50%;
  margin: auto 18%;
  padding: 20px;
}
</style>
