package io.wilson.sharding.service.impl;

import io.wilson.sharding.domain.OrderInfo;
import io.wilson.sharding.mapper.OrderInfoMapper;
import io.wilson.sharding.service.OrderInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * OrderInfo-订单表业务接口
 * </p>
 * 
 * @author 
 * @since 2020-01-13
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService{
    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Override
    public Long insert(OrderInfo orderInfo){
        orderInfoMapper.insert(orderInfo);
        return orderInfo.getId();
    }

    @Override
    public boolean updateById(OrderInfo orderInfo){
        return orderInfoMapper.updateById(orderInfo) > 0;
    }

    @Override
    public OrderInfo findById(Long id){
        return orderInfoMapper.selectById(id);
    }

    @Override
    public boolean deleteById(Long id){
        return orderInfoMapper.deleteById(id) > 0;
    }

    @Override
    public Long insertOne(OrderInfo orderInfo) {
        return orderInfoMapper.insertOne(orderInfo);
    }

    @Override
    public List<OrderInfo> list() {
        return orderInfoMapper.selectList(null);
    }
}
