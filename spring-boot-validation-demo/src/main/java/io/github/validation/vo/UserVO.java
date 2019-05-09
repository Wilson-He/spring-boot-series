package io.github.validation.vo;

import io.github.validation.group.InsertGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author: Wilson
 * @date: 2019/5/9
 **/
@Data
public class UserVO {
    @NotBlank(groups = InsertGroup.class)
    private String username;
    private String password;
}
