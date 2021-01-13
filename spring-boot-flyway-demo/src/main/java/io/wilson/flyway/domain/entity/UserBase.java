package io.wilson.flyway.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2021-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserBase implements Serializable {
    private Long id;
    /**
     * 昵称
     */
    private String nickname;
    private String status;
    /**
     * 性别(MALE:1-男性,FEMALE:0-女性)
     */
    private Integer sex;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 生日
     */
    private Long birthday;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
