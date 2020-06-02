package io.wilson.dynamic.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.wilson.dynamic.domain.entity.Role;
import io.wilson.dynamic.domain.entity.UserBase;
import io.wilson.dynamic.mapper.RoleMapper;
import io.wilson.dynamic.mapper.UserBaseMapper;
import io.wilson.dynamic.service.UserBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * UserBase-业务接口
 * </p>
 *
 * @author
 * @since 2020-05-14
 */
@Service
@DS("wilson")
public class UserBaseServiceImpl extends ServiceImpl<UserBaseMapper, UserBase> implements UserBaseService {
    @Resource
    private UserBaseMapper userBaseMapper;

}
