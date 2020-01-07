package io.wilson.docker;

import io.springframework.common.response.ServerResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wilson
 * @since 2020/1/7
 **/
@SpringBootApplication
@RestController
@RequestMapping("/")
public class QuickApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuickApplication.class, args);
    }

    @GetMapping("/hello")
    public ServerResponse hello() {
        return ServerResponse.success("Hello World");
    }
}
