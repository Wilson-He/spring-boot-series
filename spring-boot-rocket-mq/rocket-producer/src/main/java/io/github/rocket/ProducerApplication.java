package io.github.rocket;

import io.rocket.common.constant.RocketConstant;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Wilson
 * @since 2019/11/26
 **/
@SpringBootApplication
@RestController
@RequestMapping("/")
public class ProducerApplication {
    @Resource
    private RocketMQTemplate mqTemplate;

    @GetMapping("/send")
    public String send(@RequestParam String msg) {
        mqTemplate.send(RocketConstant.Topic.SPRING_BOOT_TOPIC, MessageBuilder.withPayload(msg).build());
        return "success";
    }

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }
}
