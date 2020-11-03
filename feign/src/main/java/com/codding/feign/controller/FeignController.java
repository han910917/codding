package com.codding.feign.controller;

import com.codding.feign.server.FeignServer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author hgm
 * @Time 2020/11/3 19:11
 */
@RestController
public class FeignController {

    @Resource
    private FeignServer feignServer;

    @GetMapping("/echo")
    public String echo(){
        return feignServer.echo();
    }
}
