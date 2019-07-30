package io.github.webflux.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.webflux.entity.ProductSpec;
import io.github.webflux.mapper.ProductSpecMapper;
import io.github.webflux.service.ProductSpecService;
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
public class ProductSpecServiceImpl extends ServiceImpl<ProductSpecMapper, ProductSpec> implements ProductSpecService {

}
