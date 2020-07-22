package io.github.test;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Sets;
import io.github.test.model.UserVO;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: Wilson
 * @date: 2019/5/7
 **/
@SpringBootApplication
@MapperScan("io.github.test.mapper")
@RestController
public class TestApplication {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
