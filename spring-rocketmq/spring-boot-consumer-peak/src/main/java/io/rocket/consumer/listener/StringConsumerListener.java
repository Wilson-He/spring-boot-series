package io.rocket.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Service;

/**
 * @author Wilson
 * @since 2019/11/27
 **/
@Slf4j
// @RocketMQMessageListener(consumerGroup = RocketConstant.ConsumerGroup.SPRING_BOOT_CONSUMER, topic = RocketConstant.Topic.SPRING_BOOT_TOPIC)
@Service
public class StringConsumerListener implements RocketMQListener<MessageExt>, RocketMQPushConsumerLifecycleListener {

    @Override
    public void onMessage(MessageExt msg) {
        log.info("StringConsumerListener payload: {}, queue: {}", new String(msg.getBody()), msg.getQueueId());
    }

    @Override
    public void prepareStart(DefaultMQPushConsumer consumer) {
        consumer.setPullInterval(2000);
        consumer.setPullBatchSize(16);
    }

}
