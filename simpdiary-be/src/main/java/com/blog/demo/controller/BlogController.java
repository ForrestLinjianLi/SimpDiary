package com.blog.demo.controller;


import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.demo.common.Result;
import com.blog.demo.entity.Blog;
import com.blog.demo.service.BlogService;
import com.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-08-20
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/blogs")
    public Object blogs(Integer currentPage) {
        currentPage = currentPage == null? 1:currentPage;
        Page page = new Page(currentPage, 5);
        IPage pageData = blogService.page(page, new QueryWrapper<Blog>().orderByDesc("created"));
        return Result.success(pageData);
    }

    @RequiresAuthentication
    @PutMapping("/edit")
    public Object edit(@Validated @RequestBody Blog blog) {
        Long blogId = blog.getId();
        Blog temp;
        AccountProfile profile = (AccountProfile) SecurityUtils.getSubject().getPrincipal();
        if (blogId != null) {
            temp = blogService.getById(blogId);
            Assert.isTrue(temp.getUserId().equals(profile.getId()));
        } else {
            temp = new Blog();
            temp.setUserId(profile.getId());
            temp.setCreated(LocalDateTime.now());
            temp.setStatus(0);
        }
        BeanUtils.copyProperties(blog, temp, "id", "userId", "created", "status");
        blogService.saveOrUpdate(temp);
        return Result.success("success!");

    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable(name = "id") Long id) {
        Blog blog = blogService.getById(id);
        Assert.notNull(blog, "该博客已删除！");
        return Result.success(blog);
    }
}
