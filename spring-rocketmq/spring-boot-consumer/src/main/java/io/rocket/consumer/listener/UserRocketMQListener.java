package io.rocket.consumer.listener;

import com.alibaba.fastjson.JSONObject;
import io.rocket.common.constant.RocketConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author Wilson
 * @since 2019/12/9
 **/
@Slf4j
@RocketMQMessageListener(consumerGroup = RocketConstant.ConsumerGroup.SPRING_BOOT_USER_CONSUMER, topic = RocketConstant.Topic.SPRING_BOOT_USER_TOPIC)
@Service
public class UserRocketMQListener implements RocketMQListener<MessageExt> {
    @Override
    public void onMessage(MessageExt messageExt) {
        log.info("receive message: {}", JSONObject.parse(messageExt.getBody()));
    }

/*    @Override
    public void onMessage(UserInfo userInfo) {
        log.info("receive user: {}", userInfo);
    }*/
}