package io.wilson.flyway.service.impl;

import io.wilson.flyway.domain.entity.UserBase;
import io.wilson.flyway.mapper.UserBaseMapper;
import io.wilson.flyway.service.UserBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * UserBase-业务接口
 * </p>
 * 
 * @author 
 * @since 2021-01-12
 */
@Service
public class UserBaseServiceImpl implements UserBaseService{
    @Resource
    private UserBaseMapper userBaseMapper;

}
