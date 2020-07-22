package io.github.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ex_hewx
 * @date 2020/6/28
 */
@Configuration
public class WebConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
