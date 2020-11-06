package com.codding.web.controller;

import com.codding.cache.template.MemcacheClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author hgm
 * @Time 2020/11/6 16:55
 */
@RestController
public class CacheController {

    @Autowired
    private MemcacheClient memcacheClient;

    @RequestMapping("/test")
    public Object setCache(){
        return memcacheClient.set("key", "这是key啊", 900);
    }
}
