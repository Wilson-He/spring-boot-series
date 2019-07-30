package io.github.mongo.controller;

import io.github.mongo.model.User;
import io.github.mongo.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author: Wilson
 * @date: 2019/4/29
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/")
    public Mono<User> save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{username}")
    public Mono<User> deleteByUsername(@PathVariable String username) {
        return userService.deleteByUsername(username);
    }

    @GetMapping("/{username}")
    public Mono<User> findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> findAll() {
        return userService.findAll();
    }
}
