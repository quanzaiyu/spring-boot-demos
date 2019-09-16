package com.example.web.controller;

import com.example.web.configuration.Result;
import com.example.web.model.Person;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="test", produces="application/json; charset=utf-8")
public class TestController {
    // 字符串格式输出
    @RequestMapping("hello")
    public String hello() {
        return "Hello World";
    }

    // json格式输出
    @GetMapping(value = "json")
    public Person json(){
        return new Person("xiaoyu", "23", "昆明");
    }

    // 带参数的请求
    @RequestMapping(value = "say/{name}", method = RequestMethod.GET)
    public String sayHello(@PathVariable String name) throws JSONException {
        JSONObject result = new JSONObject();
        result.put("data", "Hello " + name + "先生");
        return result.toString();
    }

    // 封装响应类
    @RequestMapping("test")
    public Result test(){
        return Result.ok("ok");
    }

}