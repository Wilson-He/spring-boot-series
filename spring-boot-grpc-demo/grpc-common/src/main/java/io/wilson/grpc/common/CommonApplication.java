package io.wilson.grpc.common;

import io.springframework.common.response.ServerResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @author Wilson
 */
@SpringBootApplication
@RestController
@RequestMapping("/index")
@Validated
public class CommonApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class);
    }

    @GetMapping("/hello")
    public ServerResponse hello(@RequestParam @NotBlank String name) {
        return ServerResponse.success("hello, " + name);
    }
}
