package io.cloud.producer;

import io.rocket.common.domain.entity.UserInfo;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Wilson
 * @since 2019/12/10
 **/
@RestController
@RequestMapping("/send")
public class MessageSenderController {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Value("${rocketmq.topic.user}")
    private String userTopic;
    @Value("${rocketmq.topic.order}")
    private String orderTopic;

    @GetMapping("/user")
    public String sendUser(@RequestParam String name) {
        rocketMQTemplate.send(userTopic, MessageBuilder.withPayload(new UserInfo().setId("1").setName(name)).build());
        return "send user success";
    }

    @GetMapping("/order")
    public String sendOrder(@RequestParam String msg) {
        rocketMQTemplate.send(orderTopic, MessageBuilder.withPayload(msg).build());
        return "send order success";
    }
}
