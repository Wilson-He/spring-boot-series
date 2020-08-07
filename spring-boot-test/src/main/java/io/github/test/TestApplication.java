package io.github.test;

import io.springframework.common.response.ServerResponse;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
@EnableDiscoveryClient
public class TestApplication {
    @Resource
    private HttpServletRequest request;

    @GetMapping("/hello")
    public ServerResponse hello() {
        System.out.println("/hello");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            System.out.println(header + ":" + request.getHeader(header));
        }
        return ServerResponse.success("/hello");
    }

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
