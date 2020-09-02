package com.blog.demo.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog.demo.common.Result;
import com.blog.demo.common.dto.UserDto;
import com.blog.demo.entity.User;
import com.blog.demo.service.UserService;
import com.shiro.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Date;


@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @CrossOrigin
    @PostMapping("/login")
    public Object login(@Validated @RequestBody UserDto userDto, HttpServletResponse response) {
        User user = userService.getOne(new QueryWrapper<User>().eq("username", userDto.getUsername()));

        Assert.notNull(user, "Account not exist!");

        if (!user.getPassword().equals(userDto.getPassword())) {
            return Result.fail("Wrong password!");
        }

        String jwt = jwtUtils.generateToken(user.getId().toString());
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        return Result.success(MapUtil.builder()
                        .put("id", user.getId())
                        .put("username", user.getUsername())
                        .put("avatar", user.getAvatar())
                        .put("email", user.getEmail())
                        .map());
    }

    @CrossOrigin
    @PostMapping("/register")
    public Object resgiter(@Validated @RequestBody UserDto userDto, HttpServletResponse response) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user.setCreated(LocalDateTime.now());
        user.setStatus(0);
        boolean isSucc = userService.save(user);
        return isSucc ? Result.success("success") :
                Result.fail("fail");
    }

    @RequestMapping("/logout")
    public Object logout() {
        SecurityUtils.getSubject().logout();
        return Result.success("null");
    }

    @RequestMapping("/test")
    public Result test() {
        return Result.success("Success");
    }

}

