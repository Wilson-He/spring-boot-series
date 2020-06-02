package io.wilson.dynamic.controller;

import io.springframework.common.response.ServerResponse;
import io.wilson.dynamic.service.RoleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 角色控制器
 * </p>
 *
 * @author
 * @since 2020-05-14
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @PostMapping("/")
    public ServerResponse add(@Validated @RequestBody Object vo) {
        return null;
    }

    @GetMapping("/")
    public ServerResponse get(@RequestParam String id) {
        return null;
    }

    @GetMapping("/page")
    public ServerResponse page(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "15") Integer size) {
        return ServerResponse.success(roleService.list());
    }

    @PutMapping("/")
    public ServerResponse update(@Validated @RequestBody Object vo) {
        return null;
    }

    @DeleteMapping("/")
    public ServerResponse delete(@RequestParam String id) {
        return null;
    }
}
