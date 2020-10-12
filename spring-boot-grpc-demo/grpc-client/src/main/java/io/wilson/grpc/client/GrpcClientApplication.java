package io.wilson.grpc.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Wilson
 */
@SpringBootApplication
@EnableAsync
public class GrpcClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrpcClientApplication.class, args);
    }
}
