<template>
  <div class="m-content">
    <Header></Header>
    <el-divider></el-divider>
    <el-collapse>
        <el-collapse-item v-bind:key="blog.id" v-bind:timestamp="blog.created" placement="top" v-for="blog in blogs">
            <template slot="title">
                <h1>
                  <router-link :to="{name: 'BlogDetail', params: {id: blog.id, title: blog.title,
                content:blog.content, created: blog.created}}">
                    {{blog.title}}
                  </router-link>
                </h1>
            </template>
            <p>{{blog.content}}</p>

        </el-collapse-item>
    </el-collapse>
  </div>
</template>

<script>
import Header from "./Header";
export default {

  name: "Blogs",
  components: {Header},
  data() {
    return {
      blogs: {},
      currentPage:1,
      total:0,
      pageSize:5
    }
  },
  methods: {
    page(currentPage) {
      this.$axios.get('http://localhost:8080/blog/blogs').then((res) => {
        this.blogs = res.data.data.records
        this.currentPage = res.data.data.current
        this.total = res.data.data.total
      })
    }
  },
  mounted() {
    this.page(1)
  }
}
</script>

<style scoped>
.el-timeline {
  width: 90%;
  text-align: left;
}
</style>
