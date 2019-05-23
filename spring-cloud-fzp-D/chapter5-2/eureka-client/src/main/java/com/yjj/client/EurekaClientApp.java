package com.yjj.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2019/4/24 10:11
 * @Version: 1.0
 */
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApp.class,args);
    }
}
