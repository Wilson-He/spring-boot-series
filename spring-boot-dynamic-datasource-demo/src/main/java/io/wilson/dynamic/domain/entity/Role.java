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
 * 角色表
 * </p>
 *
 * @author 
 * @since 2020-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Role implements Serializable {
    private Long id;
    /**
     * 名称
     */
    private String name;
    private String description;
    /**
     * 状态(DISABLE:0-禁用,ENABLE:1-可用)
     */
    private Integer state;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    /**
     * 创建管理员id
     */
    private String creatorAdminId;

}
