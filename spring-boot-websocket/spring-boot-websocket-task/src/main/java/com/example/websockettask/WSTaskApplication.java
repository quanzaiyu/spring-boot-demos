package com.example.websockettask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WSTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(WSTaskApplication.class, args);
    }
}