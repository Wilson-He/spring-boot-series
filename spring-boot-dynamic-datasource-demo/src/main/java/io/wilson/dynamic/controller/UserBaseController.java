package io.wilson.dynamic.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.springframework.common.response.ServerResponse;
import io.wilson.dynamic.domain.entity.UserBase;
import io.wilson.dynamic.service.UserBaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author
 * @since 2020-05-14
 */
@RestController
@RequestMapping("/userBase")
public class UserBaseController {
    @Resource
    private UserBaseService userBaseService;

    @PostMapping("/")
    public Object add(@Validated @RequestBody UserBase vo) {
        return null;
    }

    @GetMapping("/")
    public Object get(@RequestParam String id) {
        return null;
    }

    @GetMapping("/page")
    public Object page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "15") Integer size) {
        return ServerResponse.success(userBaseService.list(new LambdaQueryWrapper<UserBase>().gt(UserBase::getId,1L)));
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
