package io.github.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.test.domain.entity.Product;
import io.github.test.domain.entity.UserBase;
import io.github.test.mapper.ProductMapper;
import io.github.test.mapper.UserBaseMapper;
import io.github.test.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author
 * @since 2019-05-07
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private UserBaseMapper userBaseMapper;

    @PostConstruct
    public void init() {
        productMapper.deleteById(1);
        userBaseMapper.deleteById(1);
    }
}
