package io.github.test;

import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import io.github.generator.factory.DefaultGeneratorConfigFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.Date;

/**
 * @author: Wilson
 * @date: 2019/5/7
 **/
@SpringBootApplication
@MapperScan("io.github.test.mapper")
public class TestApplication {
    public static void main(String[] args) {
//        System.out.println(System.currentTimeMillis());
//        generate();
        SpringApplication.run(TestApplication.class);
    }

    @Bean
    public PerformanceInterceptor performanceInterceptor(){
        return new PerformanceInterceptor();
    }

    public static void generate() {
        try {
            DefaultGeneratorConfigFactory.defaultAutoGenerator("application.yml", "io.github.test")
                    .getGlobalConfig()
                    .setBaseResultMap(true)
                    .backGenerator()
                    .getTemplateConfig()
                    .setEntity("templates/custom-entity.java.ftl")
                    .excludeController()
                    .backGenerator()
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
