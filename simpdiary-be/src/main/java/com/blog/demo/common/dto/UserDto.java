package com.blog.demo.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDto {
    @NotBlank(message = "Username is empty!")
    private String username;
    @NotBlank(message = "Password is empty!")
    private String password;
    private String email;
    private String avatar;
}
