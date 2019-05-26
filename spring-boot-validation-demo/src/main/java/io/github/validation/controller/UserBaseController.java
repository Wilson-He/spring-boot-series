package io.github.validation.controller;

import io.github.validation.group.InsertGroup;
import io.github.validation.group.UpdateGroup;
import io.github.validation.vo.UserVO;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

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
@Validated
public class UserBaseController {


    @PostMapping("/")
    public UserVO add(@RequestBody @Validated(InsertGroup.class) UserVO vo) {
        return vo;
    }

    @PutMapping("/")
    public UserVO update(@RequestBody @Validated(UpdateGroup.class) UserVO vo) {
        return vo;
    }

    @DeleteMapping("/")
    public UserVO delete(@RequestParam @Min(0) Integer id, @RequestParam @Pattern(regexp = "AAA|BBB", message = "test必须符合正则AAA|BBB") String test) {
        return null;
    }

}

