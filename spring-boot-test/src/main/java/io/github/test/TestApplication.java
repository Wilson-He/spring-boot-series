package io.github.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author: Wilson
 * @date: 2019/5/7
 **/
@SpringBootApplication
@MapperScan("io.github.test.mapper")
@RestController
public class TestApplication {
    @Resource
    private HttpServletRequest request;

    @GetMapping("/hello")
    public String hello(){
        System.err.println(request.getHeader("Authorization"));
        return "hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
