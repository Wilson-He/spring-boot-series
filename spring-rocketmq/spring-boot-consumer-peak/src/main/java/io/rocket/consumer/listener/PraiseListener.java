package io.rocket.consumer.listener;

import io.rocket.common.constant.RocketConstant;
import io.rocket.common.domain.entity.PraiseRecord;
import io.rocket.common.service.PraiseRecordService;
import io.rocket.common.vo.PraiseRecordVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@RocketMQMessageListener(topic = RocketConstant.Topic.PRAISE_TOPIC, consumerGroup = RocketConstant.ConsumerGroup.PRAISE_CONSUMER)
@Slf4j
public class PraiseListener implements RocketMQListener<PraiseRecordVO>, RocketMQPushConsumerLifecycleListener {
    @Resource
    private PraiseRecordService praiseRecordService;

    @Override
    public void onMessage(PraiseRecordVO vo) {
//        log.info("1");
        praiseRecordService.insert(vo.copyProperties(PraiseRecord::new));
    }

    @Override
    public void prepareStart(DefaultMQPushConsumer consumer) {
        // 每次拉取的间隔，单位为毫秒
        consumer.setPullInterval(2000);
        // 单次pull消息的最大条数为broker的maxTransferCountOnMessageInMemory=32，即pullBatchSize>32将不起效，除非重新设置maxTransferCountOnMessageInMemory
        // 设置每次拉取的消息数为32
        consumer.setPullBatchSize(16);
    }
}
