package io.github.test.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author Wilson
 * @date 2019/7/3
 **/
@Getter
@Setter
public class UserVO {
    @NotBlank
    private String name;
    @Max(20)
    @NotNull
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVO userVO = (UserVO) o;
        return Objects.equals(name, userVO.name) &&
                Objects.equals(age, userVO.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
