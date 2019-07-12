package io.github.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.test.domain.entity.UserDetail;
import io.github.test.mapper.UserDetailMapper;
import io.github.test.service.UserDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
public class UserDetailServiceImpl extends ServiceImpl<UserDetailMapper, UserDetail> implements UserDetailService {
    @Resource
    private UserDetailMapper userDetailMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void add() {
        userDetailMapper.insert(new UserDetail().setSex("1").setAge(11));
        userDetailMapper.insert(new UserDetail().setSex("2").setAge(12));
        throw new RuntimeException("事务测试");
    }
}
