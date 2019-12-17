package io.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author Wilson
 * @since 2019-04-22
 */
@Data
@Accessors(chain = true)
public class UserBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 删除(YES:0-未删除,NO:1-已删除)
     */
    @TableLogic
    private Integer isDelete;

    /**
     * 状态(ENABLE-启用,DISABLE-禁用)
     */
    private String status;

    @Override
    public String toString() {
        return "UserBase{" +
                "id=" + id +
                ", username=" + username +
                ", password=" + password +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                ", status=" + status +
                "}";
    }
}
