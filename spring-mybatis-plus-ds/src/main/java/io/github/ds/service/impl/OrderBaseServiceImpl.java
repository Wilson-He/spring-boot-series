package io.github.ds.service.impl;


import io.github.ds.domain.entity.OrderBase;
import io.github.ds.ds.DataSource;
import io.github.ds.ds.DataSourceType;
import io.github.ds.mapper.OrderBaseMapper;
import io.github.ds.service.OrderBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * OrderBase-业务接口
 * </p>
 *
 * @author
 * @since 2019-07-10
 */
@Service
public class OrderBaseServiceImpl implements OrderBaseService {
    @Resource
    private OrderBaseMapper orderBaseMapper;

    @Override
    @DataSource(DataSourceType.ORDER)
    public List<OrderBase> list() {
        return orderBaseMapper.list();
    }

    @Override
    @DataSource(DataSourceType.ORDER)
    public List<OrderBase> selectList() {
        return orderBaseMapper.selectList(null);
    }
}
