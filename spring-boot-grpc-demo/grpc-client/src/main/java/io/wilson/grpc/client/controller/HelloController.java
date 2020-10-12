package io.wilson.grpc.client.controller;

import io.wilson.grpc.client.service.HelloClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Wilson
 */
@RestController
@RequestMapping("/home")
public class HelloController {
    @Resource
    private HelloClientService helloClientService;

    @GetMapping("/hello")
    public String hello() {
        helloClientService.sayHello();
        return "{'msg':'success'}";
    }
}
