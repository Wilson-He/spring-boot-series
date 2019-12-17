package io.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.mybatis.plus.entity.Product;
import io.mybatis.plus.mapper.ProductMapper;
import io.mybatis.plus.service.ProductService;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
