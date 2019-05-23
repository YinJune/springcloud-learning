package com.yjj.feign.web;

import com.yjj.feign.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2019/4/24 16:27
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api")
public class HiController {
    @Autowired
    private HiService hiService;

    @GetMapping("/hi")
    public String hi(@RequestParam(value = "name",required = false)String name){
        return "Hi I'm from feign! result:"+hiService.sayHi(name);
    }
}
