package com.yjj.feign.service;

import com.yjj.feign.client.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2019/4/24 16:26
 * @Version: 1.0
 */
@Service
public class HiService {
    @Autowired
    private EurekaClientFeign eurekaClientFeign;
    public String sayHi(String name){
        return eurekaClientFeign.sayHiFromClientEureka(name);
    }
}
