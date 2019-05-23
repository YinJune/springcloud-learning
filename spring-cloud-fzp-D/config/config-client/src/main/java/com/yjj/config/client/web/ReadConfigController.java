package com.yjj.config.client.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadConfigController {
    @Value("${foo}")
    private String foo;

    @GetMapping("/read/config")
    public String readConfig(){
        return foo;
    }
}
