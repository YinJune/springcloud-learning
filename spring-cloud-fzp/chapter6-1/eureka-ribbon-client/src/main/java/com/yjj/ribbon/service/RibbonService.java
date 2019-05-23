package com.yjj.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2019/4/24 15:39
 * @Version: 1.0
 */
@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(){
        return restTemplate.getForObject("http://eureka-client/client/hi",String.class);
    }

    public String hiError(){
        return "sorry hytrix error";
    }
}
