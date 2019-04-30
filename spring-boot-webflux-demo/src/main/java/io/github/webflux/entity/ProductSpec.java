package io.github.webflux.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import io.github.webflux.mapper.ProductSpecMapper;

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
