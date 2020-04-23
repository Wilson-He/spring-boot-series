package io.rocket.consumer.controller;

import io.rocket.common.constant.RocketConstant;
import io.rocket.common.domain.entity.UserInfo;
import io.rocket.common.vo.PraiseRecordVO;
import io.springframework.common.response.ServerResponse;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.RandomUtils;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @PostMapping("/praise")
    public ServerResponse praise(@RequestBody PraiseRecordVO vo) {
        rocketMQTemplate.sendOneWay(RocketConstant.Topic.PRAISE_TOPIC, MessageBuilder.withPayload(vo).build());
        return ServerResponse.success();
    }

    @PostMapping("/bbb")
    public ServerResponse bbb() {
        rocketMQTemplate.sendOneWay("BBB", MessageBuilder.withPayload(new PraiseRecordVO(1L, 1L)).build());
        return ServerResponse.success();
    }

    @PostMapping("/praiseBatch")
    public ServerResponse praiseBatchTest(@ApiParam("点赞数目") @RequestParam Integer amount) {
        IntStream.range(0, amount)
                .forEach(i -> rocketMQTemplate.sendOneWay(RocketConstant.Topic.PRAISE_TOPIC,
                        MessageBuilder.withPayload(new PraiseRecordVO(RandomUtils.nextLong(0, 10), RandomUtils.nextLong(0, 10))).build()));
        return ServerResponse.success();
    }

    @PostMapping("/batchUser")
    public ServerResponse sendBatchUser(@RequestParam Integer amount) {
        IntStream.range(0, amount)
                .forEach(i -> rocketMQTemplate.send(RocketConstant.Topic.SPRING_BOOT_USER_TOPIC,
                        MessageBuilder.withPayload(new UserInfo(i, "Wilson")).build()));
        return ServerResponse.success();
    }
}
