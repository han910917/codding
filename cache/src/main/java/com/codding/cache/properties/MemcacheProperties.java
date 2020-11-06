package com.codding.cache.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author hgm
 * @Time 2020/11/6 16:17
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.memcached")
public class MemcacheProperties {
    /**
     * memcached服务器节点
     */
    private String servers;

    /**
     * nio连接池的数量
     */
    private Integer poolSize;

    /**
     * 设置默认操作超时
     */
    private Long opTimeout;

    /**
     * 是否启用url encode机制
     */
    private Boolean sanitizeKeys;
}
