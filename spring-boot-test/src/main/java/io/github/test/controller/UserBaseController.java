package io.github.test.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.github.test.domain.entity.UserBase;
import io.github.test.service.UserBaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author
 * @since 2019-05-07
 */
@RestController
@RequestMapping("/userBase")
public class UserBaseController {
    @Resource
    private UserBaseService userBaseService;

    @PostMapping("/")
    public Object add() {
        return userBaseService.addTransaction();
    }

    @GetMapping("/")
    public String index() {
        userBaseService.list(new LambdaQueryWrapper<UserBase>()
                .eq(UserBase::getId, 1).or(condition -> condition.eq(UserBase::getStatus, 1).eq(UserBase::getIsDelete, 0)));
        return "index";
    }

    @PostMapping("/post")
    public String listPost() {
        return "post";
    }
}
