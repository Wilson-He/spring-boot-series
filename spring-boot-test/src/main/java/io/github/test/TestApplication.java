package io.github.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Wilson
 * @date: 2019/5/7
 **/
@SpringBootApplication
@MapperScan("io.github.test.mapper")
@RestController
public class TestApplication {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
