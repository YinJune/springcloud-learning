package com.yjj.feign.client;

import com.yjj.feign.config.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2019/4/24 16:22
 * @Version: 1.0
 */
@FeignClient(value = "eureka-client",configuration = FeignConfig.class,
    fallback = HiHystrix.class)
public interface EurekaClientFeign {
    @GetMapping("hi")
    String sayHiFromClientEureka(@RequestParam("name")String name);
}
