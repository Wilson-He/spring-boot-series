package io.wilson.sharding.service;

import io.springframework.common.response.ServerResponse;
import io.wilson.sharding.domain.OrderInfo;

import java.util.List;

/**
 * <p>
 * OrderInfo-订单表业务接口
 * </p>
 * 
 * @author 
 * @since 2020-01-13
 */
public interface OrderInfoService {
    Long insert(OrderInfo orderInfo);

    boolean updateById(OrderInfo orderInfo);

    OrderInfo findById(Long id);

    boolean deleteById(Long id);

    Long insertOne(OrderInfo orderInfo);

    List<OrderInfo> list();
}
