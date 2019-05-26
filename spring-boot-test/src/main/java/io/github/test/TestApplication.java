package io.github.test;

import io.github.generator.factory.DefaultGeneratorConfigFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * @author: Wilson
 * @date: 2019/5/7
 **/
@SpringBootApplication
@MapperScan("io.github.test.mapper")
public class TestApplication {
    public static void main(String[] args) {
//        generate();
        SpringApplication.run(TestApplication.class);
    }

    public static void generate() {
        try {
            DefaultGeneratorConfigFactory.defaultAutoGenerator("application.yml", "io.github.test")
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
