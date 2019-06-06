package com.yjj.nacos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: Yin JunJie
 * @date: 2019/5/31 14:03
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosClient2App {
    public static void main(String[] args) {
        SpringApplication.run(NacosClient2App.class,args);
    }
}
