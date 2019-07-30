package io.github.mybatis.generate.entity;

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
public class ProductSpec implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String color;

    private BigDecimal price;

    private String volume;

    private Integer productId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

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
