package com.redis.publish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * RedisUtil消息发布工具类
 */
public class RedisUtils {
    private static final Logger log = LoggerFactory.getLogger(RedisUtils.class);

    private RedisTemplate<String, Object> redisTemplate;

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void publish(String channal, Object obj) {
        redisTemplate.convertAndSend(channal, obj);
        log.info("-->消息发布成功! 通道:{} , 消息:{}", channal, obj);
    }
}