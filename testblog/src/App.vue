<template>
  <div id="app">
    <el-container>
      <el-header>
        <img id="logo" src="./assets/logo.png" alt="">
      </el-header>
      <h1>Simp Diary</h1>
      <el-main>
        <router-view/>
      </el-main>
      <el-divider/>
      <footer>
        <p>Author: Forrest Li<br>
          <a href="mailto:lljsg123123@gmail.com">lljsg123123@gmail.com</a>
        </p>
      </footer>
    </el-container>
  </div>
</template>

<script>
import Footer from "./views/Footer";
export default {
  name: 'App',
  components: {Footer},
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 20px;
  display: flex;
  flex-direction: column;
  height: 90vh;
}

.el-header {
  text-align: center;
  line-height: 8em;
  flex-shrink: 0;
}

.el-main {
  color: #333;
  text-align: center;
}


body > .el-container {
  margin-bottom: 20px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}

#logo {
  height: 80%;
  margin-top: 0.5em;
}
</style>
