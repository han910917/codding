package com.codding.nacosconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author hgm
 * @Time 2020/10/16 11:41
 */
@RestController
public class NacosConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalanceClient;

    @GetMapping(value = "/echo/{name}")
    public Object echo(@PathVariable(value = "name") String name){
        ServiceInstance serviceInstance = this.loadBalanceClient.choose("nacos-producer");
        String url = String.format("http://%s:%s/echo",serviceInstance.getHost(),serviceInstance.getPort());
        return restTemplate.getForObject(url, String.class);
    }
}
