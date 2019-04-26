package com.yjj.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2019/4/24 15:32
 * @Version: 1.0
 */
@EnableHystrixDashboard
@EnableHystrix
@EnableEurekaClient
@SpringBootApplication
public class EurekaRibbonClientApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaRibbonClientApp.class,args);
    }
}
