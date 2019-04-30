package io.github.webflux;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Wilson
 * @date: 2019/4/28
 **/
@SpringBootApplication
@MapperScan("io.github.webflux.mapper")
public class WebFluxApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebFluxApplication.class);
    }
}
