package com.codding.feign.server;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description
 * @Author hgm
 * @Time 2020/11/3 19:13
 */
@FeignClient(name="nacos-producer")
public interface FeignServer {

    @GetMapping("/echo")
    String echo();
}
