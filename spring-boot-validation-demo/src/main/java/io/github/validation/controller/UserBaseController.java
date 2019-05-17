package io.github.validation.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.validation.group.InsertGroup;
import io.github.validation.group.UpdateGroup;
import io.github.validation.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/")
    public UserVO add(@RequestBody @Validated(InsertGroup.class) UserVO vo) {
        return vo;
    }

    @PutMapping("/")
    public UserVO update(@RequestBody @Validated(UpdateGroup.class) UserVO vo) {
        return vo;
    }
}

