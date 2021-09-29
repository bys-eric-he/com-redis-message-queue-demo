package com.redis.subscribe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RedisSubscribeApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisSubscribeApplication.class, args);
        log.info("------->消息订阅服务启动完成<--------");
    }
}
