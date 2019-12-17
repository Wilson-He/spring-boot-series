package io.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.mybatis.plus.entity.ProductSpec;
import io.mybatis.plus.mapper.ProductSpecMapper;
import io.mybatis.plus.service.ProductSpecService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Wilson
 * @since 2019-04-22
 */
@Service
public class ProductSpecServiceImpl extends ServiceImpl<ProductSpecMapper, ProductSpec> implements ProductSpecService {
}
