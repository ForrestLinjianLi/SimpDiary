package com.blog.demo.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class Result implements Serializable {

    private int code;
    private String msg;
    private Object data;

    public static Result success(Object data) {
        Result r = new Result();
        r.code = 200;
        r.data = data;
        r.msg = "Success!";
        return r;
    }

    public static Result fail(String msg) {
        Result r = new Result();
        r.code = 500;
        r.data = null;
        r.msg = msg;
        return r;
    }
}
