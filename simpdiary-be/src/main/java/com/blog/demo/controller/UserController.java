package com.blog.demo.controller;

import com.blog.demo.common.Result;
import com.blog.demo.entity.User;
import com.blog.demo.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-08-20
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public Object test() {
        return "Success";
    }

    @RequiresAuthentication
    @GetMapping("/{id}")
    public Object getUser(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PostMapping("/addUser")
    public Object addUser(@Validated @RequestBody User user) {
        return user.toString();
    }
}
