package io.rocket.consumer.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.rocket.common.constant.RocketConstant;
import io.rocket.common.domain.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Configuration
public class OriginConsumer {
    @Value("${rocketmq.name-server}")
    private String nameServer;

    //    @Bean
    public DefaultMQPushConsumer defaultMQPushConsumer() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(RocketConstant.ConsumerGroup.SPRING_BOOT_CONSUMER);
        consumer.setNamesrvAddr(nameServer);
        consumer.subscribe(RocketConstant.Topic.SPRING_BOOT_TOPIC, "*");
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context)
                -> {
            log.info("-----------------receive msg size: {} -------------------", msgs.size());
            msgs.forEach(msg -> log.info("msg content: {}", JSON.parse(msg.getBody())));
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
        return consumer;
    }

    @Bean
    public DefaultMQPushConsumer userMQPushConsumer() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(RocketConstant.ConsumerGroup.SPRING_BOOT_USER_CONSUMER);
        consumer.setNamesrvAddr(nameServer);
        consumer.subscribe(RocketConstant.Topic.SPRING_BOOT_USER_TOPIC, "*");
        // 设置每次消息拉取的时间间隔，单位毫秒
        consumer.setPullInterval(1000);
        // 设置消费者单次批量消费的消息数目上限
        consumer.setPullBatchSize(24);
        // 设置消费者在每条队列消费的消息数目上限
        consumer.setConsumeMessageBatchMaxSize(12);
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context)
                -> {
            List<UserInfo> userInfos = new ArrayList<>(msgs.size());
            // 8为队列数
            Map<Integer, Integer> queueMsgMap = new HashMap<>(8);
            msgs.forEach(msg -> {
                userInfos.add(JSONObject.parseObject(msg.getBody(), UserInfo.class));
                queueMsgMap.compute(msg.getQueueId(), (key, val) -> val == null ? 1 : ++val);
            });
            log.info("userInfo size: {}, content: {}", userInfos.size(), userInfos);
            /*
              处理批量消息，如批量插入：userInfoMapper.insertBatch(userInfos);
             */
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
        return consumer;
    }

}
