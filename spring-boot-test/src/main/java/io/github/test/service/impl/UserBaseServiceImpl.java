package io.github.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.test.domain.entity.UserBase;
import io.github.test.domain.entity.UserDetail;
import io.github.test.mapper.UserBaseMapper;
import io.github.test.service.UserBaseService;
import io.github.test.service.UserDetailService;
import org.springframework.stereotype.Service;

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
public class UserBaseServiceImpl extends ServiceImpl<UserBaseMapper, UserBase> implements UserBaseService {
    @Resource
    private UserDetailService userDetailService;

    @Override
    public Object addTransaction() {
        userDetailService.add();
        return "success";
    }
}
