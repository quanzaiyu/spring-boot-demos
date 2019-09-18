package com.example.mybatisxml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybatisxml.mapper")
public class MyBatisXmlApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisXmlApplication.class, args);
    }
}
