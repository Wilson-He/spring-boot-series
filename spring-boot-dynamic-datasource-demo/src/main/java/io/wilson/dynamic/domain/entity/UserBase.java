package io.wilson.dynamic.domain.entity;

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
 * @since 2020-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserBase implements Serializable {
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    private String password;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    /**
     * 删除(YES:1-已删除,NO:0-未删除)
     */
    private Integer isDelete;
    /**
     * 状态(ENABLE:启用,DISABLE:禁用)
     */
    private String status;
    private String state;

}
