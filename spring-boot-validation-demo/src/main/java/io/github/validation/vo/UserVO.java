package io.github.validation.vo;

import io.github.validation.group.InsertGroup;
import io.github.validation.group.UpdateGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 * @author: Wilson
 * @date: 2019/5/9
 **/
@Data
@Valid
@Accessors(chain = true)
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
    @Positive(groups = {InsertGroup.class, UpdateGroup.class})
    private Double pattern;
}
