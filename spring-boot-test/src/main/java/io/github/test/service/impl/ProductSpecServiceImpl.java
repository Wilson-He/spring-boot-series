package io.github.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.test.domain.entity.ProductSpec;
import io.github.test.mapper.ProductSpecMapper;
import io.github.test.service.ProductSpecService;
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
public class ProductSpecServiceImpl extends ServiceImpl<ProductSpecMapper, ProductSpec> implements ProductSpecService {

}
