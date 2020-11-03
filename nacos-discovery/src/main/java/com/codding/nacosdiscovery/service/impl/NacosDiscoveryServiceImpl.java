package com.codding.nacosdiscovery.service.impl;

import com.codding.nacosdiscovery.service.NacosDiscoveryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author hgm
 * @Time 2020/11/3 19:17
 */
@Service
public class NacosDiscoveryServiceImpl implements NacosDiscoveryService {

    @Value("${server.port}")
    private String port;

    @Override
    public String echo() {
        return "服务端口是: " + port;
    }
}
