package com.yjj.nacos.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Yin JunJie
 * @date: 2019/5/31 14:04
 */
@RestController
public class HiController {
    Logger logger = LoggerFactory.getLogger("yjj");

    @GetMapping("/hi")
    public String hi() {
        logger.debug("debug logging...");
        logger.info("info logging...测试中文");
        logger.warn("warn logging...");
        logger.error("error logging...");
        return "Hi,I'm client2";
    }
}
