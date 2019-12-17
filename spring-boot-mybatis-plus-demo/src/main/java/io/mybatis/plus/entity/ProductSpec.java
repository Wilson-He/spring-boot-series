package io.mybatis.plus.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author Wilson
 * @since 2019-04-22
 */
@Accessors(chain = true)
@Data
public class ProductSpec implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String color;

    private BigDecimal price;

    private String volume;

    private Integer productId;

    @Override
    public String toString() {
        return "ProductSpec{" +
                "id=" + id +
                ", color=" + color +
                ", price=" + price +
                ", volume=" + volume +
                ", productId=" + productId +
                "}";
    }
}
