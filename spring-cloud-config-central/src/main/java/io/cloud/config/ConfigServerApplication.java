package io.cloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

import javax.annotation.PostConstruct;

/**
 * @author Wilson
 * @since 2019/12/9
 **/
@SpringBootApplication
//@EnableDiscoveryClient
@EnableConfigServer
public class ConfigServerApplication {
  /*  @Value("${rocketmq.topic}")
    private String topic;

    @PostConstruct
    public void init() {
        System.out.println("topic:" + topic);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
