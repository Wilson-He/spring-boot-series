package io.wilson.sharding.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author Wilson
 * @since 2020/1/14
 **/
@Configuration
public class WebConfig {
    @Resource
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init(){
    }
}
