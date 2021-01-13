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
 * 用户授权表
 * </p>
 *
 * @author 
 * @since 2021-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserAuth implements Serializable {
    private Long id;
    private Long uid;
    private Integer identityType;
    private String identifier;
    private String certificate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
