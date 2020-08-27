<template>
  <div class="main">
    <Header/>
    <el-row class="title">
      <h2 class="title-text">
        {{this.title}}
      </h2>
    </el-row>
    <el-main class="grid-content bg-purple-dark">
      {{this.content }}
    </el-main>
  </div>
</template>

<script>
import Header from "./Header";
export default {
  name: "BlogDetail",
  components: {Header},
  comments: {Header},
  data() {
    return {
      content: "",
      title: "",
      id: "",
      created: ""
    }
  },
  created() {
    let params = this.$route.params
    this.content = params.content
    this.title = params.title
    this.id = params.id
    this.created = params.created
  }
}
</script>

<style scoped>
.bg-purple-dark {
  background: #F2F6FC;
}

.title-text {
  text-align: left;
  margin-left: 2%;
}

.title {
  height: 4.5em;
  background: #409EFF;
  border-radius: 8px;
  margin-bottom: 10px;
}

.grid-content {
  border-radius: 8px;
  min-height: 40em;
}

.main {
  padding-block: 20px;
}
</style>
