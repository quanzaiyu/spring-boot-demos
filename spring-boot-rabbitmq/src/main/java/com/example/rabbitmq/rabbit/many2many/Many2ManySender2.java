package com.example.rabbitmq.rabbit.many2many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Many2ManySender2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i) {
        String context = "queue " + i;
        System.out.println("Sender2 : " + context);
        this.rabbitTemplate.convertAndSend("many2many", context);
    }
}
