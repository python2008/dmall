package com.dmall.component.cache.redis.lock;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.time.Duration;
import java.util.Collections;

/**
 * @description: 分布式锁服务
 * @author: created by hang.yu on 2019/11/3 23:07
 */

public class DistributedLockService {

    DefaultRedisScript<Boolean> redisScript;
    private StringRedisTemplate stringRedisTemplate;

    public DistributedLockService(StringRedisTemplate stringRedisTemplate, DefaultRedisScript<Boolean> redisScript) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.redisScript = redisScript;
    }

    /**
     * 加锁
     *
     * @param key     锁的key
     * @param value   锁的值
     * @param timeout 锁的过期时间
     */
    public boolean getLock(String key, String value, long timeout) {
        return stringRedisTemplate.opsForValue().setIfAbsent(key, value, Duration.ofSeconds(timeout));
    }

    /**
     * 解锁
     *
     * @param key       锁的key
     * @param requestId 锁的值
     */
    public boolean releaseLock(String key, String requestId) {
        return stringRedisTemplate.execute(redisScript, Collections.singletonList(key), requestId);

    }

}
