package com.yjj.nacos.rabbit.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Yin JunJie
 * @date: 2019/6/4 16:58
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "hello ";
        System.out.println("Sender : " + context);
        //简单对列的情况下routingKey即为Q名
        this.rabbitTemplate.convertAndSend("q_hello", context);
    }

    public void sendTopic1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("testexchange", "topic.message", context);
    }


    public void sendTopic2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("testexchange", "topic.messages", context);
    }

    public void sendFanoutA() {
        String context = "fanoutExchange messageA";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange", "",context);
    }
    public void sendFanoutB() {
        String context = "fanoutExchange messageB";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
    }
    public void sendFanoutC() {
        String context = "fanoutExchange messageC";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
    }
    public void sendRouteA() {
        String context = "routeExchange messageA";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("routeExchange","a", context);
    }
    public void sendRouteB() {
        String context = "routeExchange messageB";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("routeExchange","b", context);
    }
}
