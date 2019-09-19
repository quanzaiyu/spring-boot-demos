package com.example.rabbitmq.rabbit.one2many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class One2ManySender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i) {
        String context = "queue " + i;
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("one2many", context);
    }
}
