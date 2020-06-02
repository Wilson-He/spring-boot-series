package io.wilson.dynamic.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.wilson.dynamic.domain.entity.Role;
import io.wilson.dynamic.mapper.RoleMapper;
import io.wilson.dynamic.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * Role-角色表业务接口
 * </p>
 *
 * @author
 * @since 2020-05-14
 */
@Service
@DS("market_user")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Resource
    private RoleMapper roleMapper;

}
