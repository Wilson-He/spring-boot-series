package io.github.mybatis.generate.controller;

import io.github.mybatis.generate.entity.UserBase;
import io.github.mybatis.generate.service.UserBaseService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Wilson
 * @since 2019-04-22
 */
@RestController
@RequestMapping("/userBase")
@Api
public class UserBaseController {
    @Resource
    private UserBaseService userBaseService;

    @GetMapping("/")
    public List<UserBase> list() {
        return userBaseService.list();
    }
}

