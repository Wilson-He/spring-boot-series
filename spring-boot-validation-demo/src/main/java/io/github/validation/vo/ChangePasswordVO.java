package io.github.validation.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author Wilson
 * @since 2019/11/25
 **/
@Data
public class ChangePasswordVO {
    @NotNull
    private Long id;
    @NotBlank
    private String oldPassword;
    @NotBlank
    private String newPassword;
    @NotBlank
    private String verifyNewPassword;

    @AssertTrue(message = "新密码与确认密码不同")
    @JsonIgnore // 避免作为属性显示到swagger上
    public boolean isPasswordEquals() {
        return Objects.equals(newPassword, verifyNewPassword);
    }
}
