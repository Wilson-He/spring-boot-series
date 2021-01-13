package io.wilson.flyway.controller;

import io.wilson.flyway.service.UserBaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2021-01-12
 */
@RestController
@RequestMapping("/userBase")
public class UserBaseController {
    @Resource
    private UserBaseService userBaseService;

    @PostMapping("/")
    public Object add(@Validated @RequestBody Object vo) {
        return null;
    }

    @GetMapping("/")
    public Object get(@RequestParam String id) {
        return null;
    }

    @GetMapping("/page")
    public Object page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "15") Integer size) {
        return null;
    }

    @PutMapping("/")
    public Object update(@Validated @RequestBody Object vo) {
        return null;
    }

    @DeleteMapping("/")
    public Object delete(@RequestParam String id) {
        return null;
    }
}
