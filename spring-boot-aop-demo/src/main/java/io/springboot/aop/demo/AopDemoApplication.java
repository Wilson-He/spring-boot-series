package io.springboot.aop.demo;

import io.springboot.aop.demo.aspect.BusinessException;
import io.springboot.aop.demo.aspect.LogPointcut;
import io.springframework.common.response.DefaultCodeMsg;
import io.springframework.common.response.ServerResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wilson
 */
@SpringBootApplication
@RestController
@RequestMapping("/aop")
public class AopDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(AopDemoApplication.class);
    }

    @GetMapping("/error")
    @LogPointcut
    public ServerResponse error() {
        throw new BusinessException(DefaultCodeMsg.SERVER_ERROR);
    }
}
