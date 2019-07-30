package io.github.webflux.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author Wilson
 * @since 2019-04-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProductSpec implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String color;

    private BigDecimal price;

    private String volume;

    private Integer productId;

}
