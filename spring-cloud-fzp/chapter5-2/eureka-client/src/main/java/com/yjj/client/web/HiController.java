package com.yjj.client.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2019/4/24 10:13
 * @Version: 1.0
 */
@RestController
public class HiController {
    @Value("${server.port}")
    private String port;

    @GetMapping("hi")
    public String hi(){
        System.out.println(port);
        return "success";
    }
}