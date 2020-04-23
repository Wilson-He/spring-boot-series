package io.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.mybatis.plus.domain.constant.UserBaseConstant;

import java.util.Objects;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Wilson
 * @since 2020-04-09
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
     * 删除(1-已删除,0-未删除),{@link io.mybatis.plus.domain.constant.UserBaseConstant}
     */
    private Integer isDelete;
    /**
     * 状态(ENABLE:启用,DISABLE:禁用)
     */
    private String status;

    public String getIsDeleteComment() {
        return UserBaseConstant.IsDelete.comment(this.isDelete);
    }

    /**
     * @param isDelete {@link io.mybatis.plus.domain.constant.UserBaseConstant.IsDelete}
     */
    public boolean isIsDeleteEquals(UserBaseConstant.IsDelete isDelete) {
        return Objects.equals(this.isDelete, isDelete.getValue());
    }

    public String getStatusComment() {
        return UserBaseConstant.Status.comment(this.status);
    }

    /**
     * @param status {@link io.mybatis.plus.domain.constant.UserBaseConstant.Status}
     */
    public boolean isStatusEquals(UserBaseConstant.Status status) {
        return Objects.equals(this.status, status.getValue());
    }

}
