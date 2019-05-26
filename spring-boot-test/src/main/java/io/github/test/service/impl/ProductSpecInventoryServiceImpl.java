package io.github.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.test.domain.entity.ProductSpecInventory;
import io.github.test.mapper.ProductSpecInventoryMapper;
import io.github.test.service.ProductSpecInventoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2019-05-07
 */
@Service
public class ProductSpecInventoryServiceImpl extends ServiceImpl<ProductSpecInventoryMapper, ProductSpecInventory> implements ProductSpecInventoryService {

}
