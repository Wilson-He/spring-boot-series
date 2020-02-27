package io.cloud.consumer.listener;

import io.rocket.common.model.UserInfo;
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
@RocketMQMessageListener(consumerGroup = "${rocketmq.consumer-group.user}", topic = "${rocketmq.topic.user}")
@Service
public class UserRocketMQListener implements RocketMQListener<UserInfo> {
    @Override
    public void onMessage(UserInfo userInfo) {
        log.info("receive user: {}", userInfo);
    }
}