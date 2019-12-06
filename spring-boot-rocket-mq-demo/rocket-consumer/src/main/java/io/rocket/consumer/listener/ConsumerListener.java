package io.rocket.consumer.listener;

import io.rocket.common.constant.RocketConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author Wilson
 * @since 2019/11/27
 **/
@Slf4j
@RocketMQMessageListener(consumerGroup = RocketConstant.ConsumerGroup.SPRING_BOOT_CONSUMER, topic = RocketConstant.Topic.SPRING_BOOT_TOPIC)
@Service
public class ConsumerListener implements RocketMQListener<MessageExt> {
    @Override
    public void onMessage(MessageExt message) {
        log.info("msg id: {}, payload: {}", message.getMsgId(), new String(message.getBody()));
    }
}
