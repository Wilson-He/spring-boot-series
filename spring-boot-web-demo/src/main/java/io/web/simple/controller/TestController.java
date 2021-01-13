package io.web.simple.controller;

import io.springframework.common.response.ServerResponse;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Wilson
 * @since 2019/12/17
 **/
@RestController
@RequestMapping("/")
@Validated
@Api(tags = "测试控制器")
@Slf4j
public class TestController {
    @GetMapping("/index")
    public ServerResponse<String> index(HttpServletRequest request) {
        System.err.println("Authorization header:" + request.getHeader("Authorization"));
        System.err.println("debug header:" + request.getHeader("debug"));
        return ServerResponse.success("index");
    }
}
