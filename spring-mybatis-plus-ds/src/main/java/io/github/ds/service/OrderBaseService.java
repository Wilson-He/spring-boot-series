package io.github.ds.service;

import io.github.ds.domain.entity.OrderBase;

import java.util.List;

/**
 * <p>
 * OrderBase-业务接口
 * </p>
 *
 * @author
 * @since 2019-07-10
 */
public interface OrderBaseService {
    List<OrderBase> list();
    List<OrderBase> selectList();
}
