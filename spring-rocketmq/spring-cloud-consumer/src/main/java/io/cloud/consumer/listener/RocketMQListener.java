package io.cloud.consumer.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author Wilson
 * @since 2019/12/9
 **/
@Service
public class RocketMQListener {
    @Value("${rocketmq.topic}")
    private String topic;

    @PostConstruct
    public void init(){
        System.out.println("topic:" + topic);
    }

}
