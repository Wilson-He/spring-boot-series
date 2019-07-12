package io.github.ds.service;

import io.github.ds.domain.entity.PaymentInfo;

import java.util.List;

/**
 * <p>
 * PaymentInfo-缴费记录表业务接口
 * </p>
 * 
 * @author 
 * @since 2019-07-11
 */
public interface PaymentInfoService {
    List<PaymentInfo> list();
}
