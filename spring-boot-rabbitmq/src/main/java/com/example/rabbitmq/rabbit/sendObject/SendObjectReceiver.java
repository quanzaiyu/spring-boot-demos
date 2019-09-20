package com.example.rabbitmq.rabbit.sendObject;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "object")
public class SendObjectReceiver {

    @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver  : " + user);
    }
}
