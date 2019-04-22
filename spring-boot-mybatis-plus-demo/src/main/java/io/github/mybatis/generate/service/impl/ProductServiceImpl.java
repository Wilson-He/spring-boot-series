package io.github.mybatis.generate.service.impl;

import io.github.mybatis.generate.entity.Product;
import io.github.mybatis.generate.mapper.ProductMapper;
import io.github.mybatis.generate.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wilson
 * @since 2019-04-22
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
