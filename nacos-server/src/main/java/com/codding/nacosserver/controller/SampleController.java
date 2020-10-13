package com.codding.nacosserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author hgm
 * @Time 2020/10/13 19:41
 */
@RefreshScope
@RestController
public class SampleController {
    
    @Value("${user.name}")
    private String userName;

    @Value("${user.age}")
    private int age;

    @GetMapping("/getUser")
    public Object getUser(){
        return "name = " + userName + "  age = " + age;
    }
}
