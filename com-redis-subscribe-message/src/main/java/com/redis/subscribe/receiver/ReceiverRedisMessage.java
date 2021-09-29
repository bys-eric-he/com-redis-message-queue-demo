package com.redis.subscribe.receiver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.redis.message.common.constant.RedisConstant;
import com.redis.message.common.pojo.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

/**
 * 消息接收处理
 */
@Service
public class ReceiverRedisMessage {
    private static final Logger log = LoggerFactory.getLogger(ReceiverRedisMessage.class);
    private CountDownLatch latch;

    @Autowired
    public ReceiverRedisMessage(CountDownLatch latch) {
        this.latch = latch;
    }

    /**
     * 队列消息接收方法,注入给MessageListenerAdapter的构造器
     *
     * @param jsonMsg
     */
    public void receiveMessage(String jsonMsg) {
        log.info("[开始消费REDIS消息队列,通道{}数据...]", RedisConstant.TOPIC_PRAISE);
        try {
            log.info("-->监听者收到消息：{}", jsonMsg);
            JSONObject exJson = JSONObject.parseObject(jsonMsg);
            UserInfo user = JSON.toJavaObject(exJson, UserInfo.class);
            System.out.println("-->转化为对象 ：" + user);
            log.info("[消费REDIS消息队列,通道{}数据成功.]", RedisConstant.TOPIC_PRAISE);
        } catch (Exception e) {
            log.error("[消费REDIS消息队列,通道{}数据失败,失败信息:{}]", RedisConstant.TOPIC_PRAISE, e.getMessage());
        }

        latch.countDown();
    }
}
