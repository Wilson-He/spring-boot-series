package io.springboot.nacos.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Wilson
 */
@SpringBootApplication
@EnableDiscoveryClient
//@NacosPropertySource(dataId = "user-provider.yml", autoRefreshed = true)
public class NacosConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApplication.class);
    }
}
