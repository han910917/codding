package com.codding.cache.template;

import lombok.extern.slf4j.Slf4j;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeoutException;

/**
 * @Description
 * @Author hgm
 * @Time 2020/11/6 16:18
 */
@Slf4j
public class MemcacheClient {
    // 默认国企时间30分钟
    private static final Integer MEMCACHE_EXPIRE = 1800;

    private MemcachedClient memcachedClient;

    public MemcacheClient(MemcachedClient memcachedClient) {
        this.memcachedClient = memcachedClient;
    }

    /**
     * 设置缓存
     * @param key
     * @param value
     * @return
     */
    public Boolean set(String key, Object value){
        return set(key, value, MEMCACHE_EXPIRE);
    }

    /**
     * 设置缓存
     * @param key
     * @param value
     * @return
     */
    public Boolean set(String key, Object value, Integer expire){
        if (StringUtils.isEmpty(key)) {
            log.info("key不能为空");
            throw new NullPointerException("key不能为空");
        }
        if (null == expire) {
            expire = MEMCACHE_EXPIRE;
        }
        try {
            return memcachedClient.set(key, expire, value);
        } catch (TimeoutException e) {
            log.info("链接memcached超时");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
