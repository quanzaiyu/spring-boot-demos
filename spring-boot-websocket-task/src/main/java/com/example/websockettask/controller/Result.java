package com.example.websockettask.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Object data;
    private Integer status;
    private String msg;

    public static Result ok(Object data){
        return new Result(data, 1, "数据请求成功");
    }

    public static Result error(String msg){
        return new Result("", 0, msg);
    }
}
