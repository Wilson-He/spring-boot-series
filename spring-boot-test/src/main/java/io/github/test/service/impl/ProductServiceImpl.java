package io.github.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.test.domain.entity.Product;
import io.github.test.mapper.ProductMapper;
import io.github.test.service.ProductService;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
