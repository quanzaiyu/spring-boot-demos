package com.example.webjars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class WebjarsApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebjarsApplication.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
