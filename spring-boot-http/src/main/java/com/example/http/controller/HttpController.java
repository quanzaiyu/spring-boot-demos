package com.example.http.controller;

import com.example.http.service.HttpAPIService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HttpController {
    @Resource
    private HttpAPIService httpAPIService;

    @RequestMapping("")
    public String index() throws Exception {
        String str = httpAPIService.doGet("https://www.baidu.com");
        System.out.println(str);
        return str;
    }
}
