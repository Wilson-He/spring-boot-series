package io.cloud.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Wilson
 * @since 2019/12/10
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudProducerApplication.class, args);
    }
}
