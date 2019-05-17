package io.github.mybatis.generate.service.impl;

import io.github.mybatis.generate.entity.ProductSpec;
import io.github.mybatis.generate.mapper.ProductSpecMapper;
import io.github.mybatis.generate.service.ProductSpecService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wilson
 * @since 2019-04-22
 */
@Service
public class ProductSpecServiceImpl extends ServiceImpl<ProductSpecMapper, ProductSpec> implements ProductSpecService {
}
