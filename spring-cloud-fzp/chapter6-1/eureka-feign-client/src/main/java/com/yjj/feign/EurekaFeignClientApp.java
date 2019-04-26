package com.yjj.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2019/4/24 16:21
 * @Version: 1.0
 */
@EnableHystrixDashboard
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class EurekaFeignClientApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaFeignClientApp.class,args);
    }
}
