package io.github.mybatis.generate.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.mybatis.generate.entity.UserBase;
import io.github.mybatis.generate.mapper.UserBaseMapper;
import io.github.mybatis.generate.service.UserBaseService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void init() {
        list();
    }

    @GetMapping("/list")
    public List<UserBase> list() {
        return userBaseService.list();
    }

    @DeleteMapping("/")
    public String delete(@RequestParam Integer id) {
        userBaseService.removeById(id);
        return "success";
    }

    @GetMapping("/")
    public UserBase selectLock(@RequestParam Integer id) {
        return userBaseService.lockSelect(id);
    }
}

