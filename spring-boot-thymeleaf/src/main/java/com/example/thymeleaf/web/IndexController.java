package com.example.thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("message", "https://www.xiaoyulive.top");
        return "hello";
    }

    @RequestMapping("/hello")
    public String index1(ModelMap map) {
        map.addAttribute("message", "https://www.xiaoyulive.top");
        return "hello";
    }
}
