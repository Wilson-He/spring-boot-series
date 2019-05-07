package io.github.test.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.test.domain.entity.UserBase;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author
 * @since 2019-05-07
 */
@RestController
@RequestMapping("/send")
public class TestController {
    @Resource
    private List<HttpMessageConverters> messageConverters;
    @Resource
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init(){
        System.err.println(messageConverters.get(0).getConverters());
    }

    @PostMapping("/")
    public Object add(@RequestBody UserBase userBase) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate(messageConverters.get(0).getConverters());
        HttpEntity<UserBase> entity = new HttpEntity<>(userBase);
        ResponseEntity responseEntity = restTemplate.postForEntity("http://localhost:8080/userBase/", entity, UserBase.class);
        return responseEntity.getBody();
    }
}
