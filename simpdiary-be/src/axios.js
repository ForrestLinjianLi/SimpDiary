import Axios from "axios"
import Element from "element-ui"

Axios.defaults.baseURL = "http://localhost:8080"

Axios.interceptors.request.use(config => {
  return config
})

Axios.interceptors.response.use(res => {
  let resData =  res.data

  if (resData.code === 200) {
    return res
  } else {
    Element.Message.error("用户名或密码不正确！", {duration: 3*1000})
  }
})
