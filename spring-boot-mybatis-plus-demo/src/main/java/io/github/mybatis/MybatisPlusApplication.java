package io.github.mybatis;

import io.github.mybatis.generate.mapper.UserBaseMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Wilson
 * @date: 2019/4/22
 **/
@SpringBootApplication
@MapperScan(basePackages = "io.github.mybatis.generate.mapper")
public class MybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class);
    }
}
