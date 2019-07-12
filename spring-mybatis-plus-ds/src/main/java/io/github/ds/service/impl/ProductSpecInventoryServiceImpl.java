package io.github.ds.service.impl;

import io.github.ds.mapper.ProductSpecInventoryMapper;
import io.github.ds.service.ProductSpecInventoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * ProductSpecInventory-业务接口
 * </p>
 *
 * @author
 * @since 2019-07-10
 */
@Service
public class ProductSpecInventoryServiceImpl implements ProductSpecInventoryService {
    @Resource
    private ProductSpecInventoryMapper productSpecInventoryMapper;
}
