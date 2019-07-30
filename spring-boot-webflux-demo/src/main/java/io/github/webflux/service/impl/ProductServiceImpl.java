package io.github.webflux.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.webflux.entity.Product;
import io.github.webflux.mapper.ProductMapper;
import io.github.webflux.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Wilson
 * @since 2019-04-28
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Resource
    private ProductMapper productMapper;

    @PostConstruct
    public void init() {
        productMapper.deleteById(1);
    }
}
