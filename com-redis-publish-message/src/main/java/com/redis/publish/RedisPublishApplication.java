package com.redis.publish;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableScheduling
@SpringBootApplication
public class RedisPublishApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisPublishApplication.class, args);
        log.info("------->消息推送服务启动完成<--------");
    }
}
