package io.github.mybatis.generate.entity;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author Wilson
 * @since 2019-04-22
 */
public class ProductSpecInventory implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer specId;

    private Integer amount;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ProductSpecInventory{" +
                "id=" + id +
                ", specId=" + specId +
                ", amount=" + amount +
                "}";
    }
}
