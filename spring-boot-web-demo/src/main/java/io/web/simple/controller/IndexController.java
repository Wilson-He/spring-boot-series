package io.web.simple.controller;

import io.springframework.common.response.ServerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

/**
 * @author Wilson
 * @since 2019/12/17
 **/
@RestController
@RequestMapping("/")
@Validated
public class IndexController {

    @GetMapping("/index")
    public ServerResponse<String> index() {
        return ServerResponse.success("index");
    }

    @GetMapping("/home")
    public ServerResponse<String> home() {
        return ServerResponse.success("home");
    }

    @GetMapping("/age")
    public ServerResponse<Long> age(@Min(8) @RequestParam Long age) {
        return ServerResponse.success(age);
    }
}
