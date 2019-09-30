package com.example.http.controller;

import com.example.http.service.HttpAPIService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HttpController {
    @Resource
    private HttpAPIService httpAPIService;

    @RequestMapping("http")
    public String index() throws Exception {
        return httpAPIService.doGet("https://www.baidu.com");
    }
}
