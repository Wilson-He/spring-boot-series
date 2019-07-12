package io.github.test.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Wilson
 * @date 2019/7/3
 **/
@Data
public class UserVO {
    @NotBlank
    private String name;
    @Max(20)
    @NotNull
    private Integer age;
}
