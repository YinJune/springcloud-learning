package com.yjj.feign.client;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2019/4/24 17:45
 * @Version: 1.0
 */
@Component
public class HiHystrix implements EurekaClientFeign {
    @Override
    public String sayHiFromClientEureka(String name) {
        return "sorry feign hytrix error";
    }
}