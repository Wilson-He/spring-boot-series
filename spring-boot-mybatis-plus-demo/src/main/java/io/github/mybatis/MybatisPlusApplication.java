package io.github.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author: Wilson
 * @date: 2019/4/22
 **/
@SpringBootApplication
@MapperScan(basePackages = "io.github.mybatis.generate.mapper")
public class MybatisPlusApplication {
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class);
    }
}
