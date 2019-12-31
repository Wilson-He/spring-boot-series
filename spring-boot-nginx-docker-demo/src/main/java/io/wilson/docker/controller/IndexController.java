package io.wilson.docker.controller;

import io.springframework.common.response.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wilson
 * @since 2019/12/30
 **/
@RestController
@Slf4j
public class IndexController {
    @GetMapping("/index")
    public ServerResponse index() {
        log.info("index");
        return ServerResponse.success("index");
    }

    @GetMapping("/error")
    public ServerResponse error() {
        log.error("error");
        return ServerResponse.success("error");
    }
}
