package io.wilson.flyway.service.impl;

import io.wilson.flyway.domain.entity.UserAuth;
import io.wilson.flyway.mapper.UserAuthMapper;
import io.wilson.flyway.service.UserAuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * UserAuth-用户授权表业务接口
 * </p>
 *
 * @author
 * @since 2021-01-12
 */
@Service
public class UserAuthServiceImpl implements UserAuthService{
    @Resource
    private UserAuthMapper userAuthMapper;

}
