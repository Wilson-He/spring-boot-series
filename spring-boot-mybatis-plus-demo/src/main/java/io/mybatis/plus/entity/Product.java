package io.mybatis.plus.entity;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author Wilson
 * @since 2019-04-22
 */
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name=" + name +
                "}";
    }
}
