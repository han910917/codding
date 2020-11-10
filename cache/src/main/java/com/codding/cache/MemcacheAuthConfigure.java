package com.codding.cache;

import com.codding.cache.properties.MemcacheProperties;
import com.codding.cache.template.MemcacheClient;
import lombok.extern.slf4j.Slf4j;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.MemcachedOptimizer;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.utils.AddrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @Description
 * @Author hgm
 * @Time 2020/11/6 16:13
 */
@Slf4j
@Configuration
@ConditionalOnClass(MemcacheProperties.class)
@EnableConfigurationProperties(MemcacheProperties.class)
public class MemcacheAuthConfigure {

    @Autowired
    private MemcacheProperties memcacheProperties;

    @Bean
    public MemcachedClient getMemcachedClient(){
        MemcachedClient memcachedClient = null;
        try {
            MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses(memcacheProperties.getServers()));
            builder.setFailureMode(false);
            builder.setSanitizeKeys(memcacheProperties.getSanitizeKeys());
            builder.setConnectionPoolSize(memcacheProperties.getPoolSize());
            builder.setOpTimeout(memcacheProperties.getOpTimeout());
            builder.setSessionLocator(new KetamaMemcachedSessionLocator());
            builder.setCommandFactory(new BinaryCommandFactory());
            memcachedClient = builder.build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return memcachedClient;
    }

    @Bean
    public MemcacheClient memcacheClient(MemcachedClient getMemcachedClient){
        return new MemcacheClient(getMemcachedClient);
    }
}
