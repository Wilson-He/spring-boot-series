package io.github.validation.vo;

import io.github.validation.group.InsertGroup;
import io.github.validation.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

/**
 * @author: Wilson
 * @date: 2019/5/9
 **/
@Data
public class UserVO {
    @NotBlank(groups = UpdateGroup.class)
    @Null(groups = InsertGroup.class)
    private Integer id;
    @NotBlank(groups = InsertGroup.class)
    private String username;
    private String password;
    @Pattern(regexp = "ENABLE|DISABLE", groups = {InsertGroup.class, UpdateGroup.class}, message = "status须符合正则ENABLE|DISABLE-test")
    private String status;
}
