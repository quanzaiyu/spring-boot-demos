package com.example.rabbitmq.controller;

import com.example.rabbitmq.rabbit.fanout.FanoutSender;
import com.example.rabbitmq.rabbit.many2many.Many2ManySender1;
import com.example.rabbitmq.rabbit.many2many.Many2ManySender2;
import com.example.rabbitmq.rabbit.one2many.One2ManySender;
import com.example.rabbitmq.rabbit.one2one.HelloSender;
import com.example.rabbitmq.rabbit.sendObject.SendObjectSender;
import com.example.rabbitmq.rabbit.sendObject.User;
import com.example.rabbitmq.rabbit.topic.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MqController {

    @Autowired
    private HelloSender helloSender;

    @Autowired
    private One2ManySender one2ManySender;

    @Autowired
    private Many2ManySender1 many2ManySender1;

    @Autowired
    private Many2ManySender2 many2ManySender2;

    @Autowired
    private SendObjectSender sendObjectSender;

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;

    @RequestMapping("/one2one")
    public String one2one () {
        helloSender.send();
        return "ok";
    }

    @RequestMapping("/one2many")
    public String one2many () {
        for (int i=0;i<100;i++){
            one2ManySender.send(i);
        }
        return "ok";
    }

    @RequestMapping("/many2many")
    public String many2many () {
        for (int i=0;i<100;i++){
            many2ManySender1.send(i);
            many2ManySender2.send(i);
        }
        return "ok";
    }

    @RequestMapping("/obj")
    public String obj () {
        User user = new User("xiaoyu", 24, "male");
        sendObjectSender.send(user);
        return "ok";
    }

    // topic
    @RequestMapping("/topic")
    public String topic () {
        topicSender.send();
        return "ok";
    }

    @RequestMapping("/topic1")
    public String topic1 () {
        topicSender.send1();
        return "ok";
    }

    @RequestMapping("/topic2")
    public String topic2 () {
        topicSender.send2();
        return "ok";
    }

    @RequestMapping("/fanout")
    public String fanout () {
        fanoutSender.send();
        return "ok";
    }
}
