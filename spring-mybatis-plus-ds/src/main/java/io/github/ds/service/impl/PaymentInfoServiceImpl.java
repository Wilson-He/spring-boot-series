package io.github.ds.service.impl;

import io.github.ds.domain.entity.PaymentInfo;
import io.github.ds.ds.DataSource;
import io.github.ds.ds.DataSourceType;
import io.github.ds.mapper.PaymentInfoMapper;
import io.github.ds.service.PaymentInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wilson
 * @date 2019/7/11
 **/
@Service
public class PaymentInfoServiceImpl implements PaymentInfoService {
    @Resource
    private PaymentInfoMapper paymentInfoMapper;

    @Override
    @DataSource(DataSourceType.PARTY)
    public List<PaymentInfo> list() {
        return paymentInfoMapper.list();
    }
}
