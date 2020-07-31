package io.github.mongo.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Wilson-He
 * @date 2020/4/24
 */
@Data
public class UserBaseVO extends BaseVO {
    @NotBlank
    private String username;
    private String name;
    private Integer age;
    private String phone;
    private List<String> sub;
}
