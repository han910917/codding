package com.codding.nacosdiscovery.controller;

import com.codding.nacosdiscovery.service.NacosDiscoveryService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private NacosDiscoveryService nacosDiscoveryService;

    @GetMapping(value = "/echo")
    public String echo(){
        return nacosDiscoveryService.echo();
    }
}
