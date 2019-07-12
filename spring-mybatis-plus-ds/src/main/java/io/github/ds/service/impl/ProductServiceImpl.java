package io.github.ds.service.impl;

import io.github.ds.mapper.ProductMapper;
import io.github.ds.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * Product-业务接口
 * </p>
 *
 * @author
 * @since 2019-07-10
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;
}
