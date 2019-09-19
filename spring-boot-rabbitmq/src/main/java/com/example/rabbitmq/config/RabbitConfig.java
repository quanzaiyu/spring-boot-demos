package com.example.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue one2manyQueue() {
        return new Queue("one2many");
    }

    @Bean
    public Queue many2manyQueue() {
        return new Queue("many2many");
    }
}
