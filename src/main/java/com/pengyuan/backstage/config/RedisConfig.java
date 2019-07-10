package com.pengyuan.backstage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author LX
 * @date 2019/7/10 - 12:46
 */
@Configuration
public class RedisConfig {


    @Primary
    @Bean
    public RedisTemplate<String,Object> redisTemplate(
            RedisConnectionFactory redisConnectionFactory){

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(redisConnectionFactory);

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        return redisTemplate;
    }

    /**
     * 定制缓存的 的 一些规则
     * @param redisTemplate
     * @return
     */
    @Bean
    public RedisCacheManager empRedisCacheManager(RedisTemplate<String,Object> redisTemplate){
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

        // key 多了一个前缀
        // 在这个地方设置了  使用前缀   会将 CacheName 作为前缀
        cacheManager.setUsePrefix(true);

        return cacheManager;
    }
}
