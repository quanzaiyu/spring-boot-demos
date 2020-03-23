package com.example.test.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.example.test.mdb.mapper"})
public class MyBatisConfig {
}
