package io.github.ds.service.impl;

import io.github.ds.mapper.UserDetailMapper;
import io.github.ds.service.UserDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * UserDetail-业务接口
 * </p>
 *
 * @author
 * @since 2019-07-10
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {
    @Resource
    private UserDetailMapper userDetailMapper;
}
