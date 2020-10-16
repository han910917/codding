package com.codding.nacosdiscovery.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author hgm
 * @Time 2020/10/16 11:28
 */
@RestController
public class NacosDiscoveryController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/echo")
    public String echo(){
        return "服务端口是: " + port;
    }
}
