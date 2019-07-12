package io.github.ds.service.impl;

import io.github.ds.mapper.ProductSpecMapper;
import io.github.ds.service.ProductSpecService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * ProductSpec-业务接口
 * </p>
 *
 * @author
 * @since 2019-07-10
 */
@Service
public class ProductSpecServiceImpl implements ProductSpecService {
    @Resource
    private ProductSpecMapper productSpecMapper;
}
