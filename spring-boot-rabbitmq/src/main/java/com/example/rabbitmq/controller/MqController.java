package com.example.rabbitmq.controller;

import com.example.rabbitmq.rabbit.many2many.Many2ManySender1;
import com.example.rabbitmq.rabbit.many2many.Many2ManySender2;
import com.example.rabbitmq.rabbit.one2many.One2ManySender;
import com.example.rabbitmq.rabbit.one2one.HelloSender;
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
}
