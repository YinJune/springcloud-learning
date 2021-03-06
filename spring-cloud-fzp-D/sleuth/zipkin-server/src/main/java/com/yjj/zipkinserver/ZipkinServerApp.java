package com.yjj.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
//import zipkin.server.EnableZipkinServer;

@SpringBootApplication
//@EnableZipkinServer
@EnableEurekaClient
@EnableZipkinStreamServer
public class ZipkinServerApp {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApp.class,args);
    }
}
