package com.yjj.nacos.web;

import com.yjj.nacos.rabbit.sender.HelloSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: Yin JunJie
 * @date: 2019/5/31 13:49
 */
@RestController
@RefreshScope
public class HiController {
    Logger logger = LoggerFactory.getLogger(HiController.class);

    @Autowired
    private HelloSender helloSender;

    @Value("${yjj.name}")
    private String name;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hi")
    public String hi() {
        logger.info("开始远程调用{}...", 123);
        return restTemplate.getForObject("http://nacosClient2:/hi", String.class);
    }

    @GetMapping("/send")
    public void send() throws InterruptedException {
        helloSender.send();
    }

    @GetMapping("/sendTopic1")
    public void sendTopic1() {
        helloSender.sendTopic1();
    }

    @GetMapping("/sendTopic2")
    public void sendTopic2() {
        helloSender.sendTopic2();
    }

    @GetMapping("/sendFanoutA")
    public void sendFanoutA() {
        helloSender.sendFanoutA();
    }

    @GetMapping("/sendFanoutB")
    public void sendFanoutB() {
        helloSender.sendFanoutB();
    }

    @GetMapping("/sendFanoutC")
    public void sendFanoutC() {
        helloSender.sendFanoutC();
    }

    @GetMapping("/sendRouteA")
    public void sendRouteA() {
        helloSender.sendRouteA();
    }

    @GetMapping("/sendRouteB")
    public void sendRouteB() {
        helloSender.sendRouteB();
    }

    @GetMapping("/sendRedeliver")
    public void sendRedeliver() {
        for (int i =0;i<3;i++){
            helloSender.send();
        }
    }

}