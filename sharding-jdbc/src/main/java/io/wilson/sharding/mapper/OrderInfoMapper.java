package io.wilson.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.wilson.sharding.domain.OrderInfo;

/**
 * <p>
 * 订单表Mapper 接口
 * </p>
 *
 * @author 
 * @since 2020-01-13
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    Long insertOne(OrderInfo orderInfo);
}
