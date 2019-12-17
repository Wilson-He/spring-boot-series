package io.mybatis.plus.controller;

import io.mybatis.plus.entity.UserBase;
import io.mybatis.plus.service.UserBaseService;
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

