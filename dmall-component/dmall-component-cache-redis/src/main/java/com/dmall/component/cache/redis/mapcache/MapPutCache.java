package com.dmall.component.cache.redis.mapcache;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: created by hang.yu on 2019/11/26 23:33
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MapPutCache {
    /**
     * 缓存key 优先级最高
     */
    String key() default "";

    /**
     * 缓存名称
     */
    String cacheName() default "";

    /**
     * 超时时间
     */
    long timeout();

    /**
     * 时间单位
     */
    TimeUnit timeUnit();

}