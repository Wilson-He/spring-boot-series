package io.cloud.consumer.listener;

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
@RocketMQMessageListener(consumerGroup = "${rocketmq.consumer-group.order}", topic = "${rocketmq.topic.order}")
@Service
public class OrderRocketMQListener implements RocketMQListener<MessageExt> {
    @Override
    public void onMessage(MessageExt message) {
        log.info("order msg id: {}, payload: {}", message.getMsgId(), new String(message.getBody()));
    }
}