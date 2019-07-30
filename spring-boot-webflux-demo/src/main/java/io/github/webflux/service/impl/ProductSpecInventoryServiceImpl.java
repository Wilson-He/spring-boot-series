package io.github.webflux.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.webflux.entity.ProductSpecInventory;
import io.github.webflux.mapper.ProductSpecInventoryMapper;
import io.github.webflux.service.ProductSpecInventoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Wilson
 * @since 2019-04-28
 */
@Service
public class ProductSpecInventoryServiceImpl extends ServiceImpl<ProductSpecInventoryMapper, ProductSpecInventory> implements ProductSpecInventoryService {

}
