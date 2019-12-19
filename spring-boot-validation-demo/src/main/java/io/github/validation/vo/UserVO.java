package io.github.validation.vo;

import io.springframework.common.validation.group.InsertGroup;
import io.springframework.common.validation.group.UpdateGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

/**
 * @author: Wilson
 * @date: 2019/5/9
 **/
@Data
public class UserVO {
    @NotBlank(groups = UpdateGroup.class)
    private String id;
    @NotBlank(groups = InsertGroup.class)
    @ApiModelProperty(value = "用户名")
    private String username;
    @NotBlank
    private String password;
    @Range(min = 1, max = 3, groups = InsertGroup.class)
    private Integer status;
}
