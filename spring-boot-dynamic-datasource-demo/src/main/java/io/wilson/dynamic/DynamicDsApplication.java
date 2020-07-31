package io.wilson.dynamic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

/**
 * @author Wilson-He
 * @date 2020/5/14
 */
@SpringBootApplication
@MapperScan("io.wilson.dynamic.mapper")
public class DynamicDsApplication {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().truncatedTo(ChronoUnit.DAYS));

//        SpringApplication.run(DynamicDsApplication.class, args);
    }

}
