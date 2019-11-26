package com.dmall.component.cache.redis.mapcache;


import java.lang.annotation.*;

/**
 * @description: MapCacheable
 * @author: created by hang.yu on 2019/11/23 22:32
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MapCacheable {

    /**
     * 缓存key 优先级最高
     */
    String key() default "";

    /**
     * 缓存名称
     */
    String cacheName() default "";

}
