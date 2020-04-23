package io.rocket.consumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.rocket")
@MapperScan("io.rocket.common.mapper")
public class PeakConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PeakConsumerApplication.class, args);
    }
}
