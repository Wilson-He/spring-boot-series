package io.github.test.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author
 * @since 2019-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProductSpecInventory implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer specId;

    private Integer amount;

}
