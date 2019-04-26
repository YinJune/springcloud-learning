package com.yjj.ribbon.web;

import com.yjj.ribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: YinJunjie
 * @CreateDate: 2019/4/24 15:33
 * @Version: 1.0
 */
@RestController
public class HiController {

    @Autowired
    private RibbonService ribbonService;

    @GetMapping("hi")
    public String hi(){
        return ribbonService.hi();
    }
}
