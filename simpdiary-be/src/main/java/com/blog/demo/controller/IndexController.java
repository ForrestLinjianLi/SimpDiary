package com.blog.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller(value = "/")
public class IndexController {

    @GetMapping("/")
    public Object test() {
        return "Success";
    }
}
