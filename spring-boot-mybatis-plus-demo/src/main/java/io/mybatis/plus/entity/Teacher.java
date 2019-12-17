package io.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author Wilson
 * @since 2019-04-22
 */
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    @TableLogic
    private String isDelete;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name=" + name +
                ", isDelete=" + isDelete +
                "}";
    }
}
