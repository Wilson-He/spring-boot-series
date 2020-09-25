package io.wilson.basic.proxy.aspectJ;

import io.springframework.common.response.ServerResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Wilson
 */
@SpringBootApplication
@RestController
@RequestMapping("/test")
public class AspectApplication {
    public static void main(String[] args) {
        SpringApplication.run(AspectApplication.class, args);
    }

    @Resource
    private Dog dog;

    @GetMapping("/dog")
    public ServerResponse serverResponse(){
//        Dog dog = new Dog();
        dog.cry();
        System.out.println(dog.getClass());
        return ServerResponse.success();
    }
}
