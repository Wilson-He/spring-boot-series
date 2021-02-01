package io.github.validation.controller;

import io.github.validation.vo.ChangePasswordVO;
import io.github.validation.vo.UserVO;
import io.springframework.common.validation.InsertGroup;
import io.springframework.common.validation.UpdateGroup;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Wilson
 * @since 2019-04-22
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserBaseController {

    @PostMapping("/")
    public Long insert(@RequestBody @Validated(InsertGroup.class) UserVO vo) {
        // do something
        return null;
    }

    @GetMapping("/")
    public ResponseEntity get(@Min(1) @RequestParam Long id) {
        // do something
        return null;
    }

    @PutMapping("/")
    public ResponseEntity update(@RequestBody @Validated(UpdateGroup.class) UserVO vo) {
        // do something
        return null;
    }

    @PutMapping("/password")
    public ResponseEntity updatePassword(@RequestBody @Validated ChangePasswordVO vo) {
        // do something
        return null;
    }

}

