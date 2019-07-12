package io.github.ds.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author
 * @since 2019-07-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserDetail implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String sex;

    private Integer age;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String isDelete;

    private Integer userId;

}
