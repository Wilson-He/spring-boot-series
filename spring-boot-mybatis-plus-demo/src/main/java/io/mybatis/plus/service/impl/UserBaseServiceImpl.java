package io.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.mybatis.plus.entity.UserBase;
import io.mybatis.plus.mapper.UserBaseMapper;
import io.mybatis.plus.service.UserBaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Wilson
 * @since 2019-04-22
 */
@Service
public class UserBaseServiceImpl extends ServiceImpl<UserBaseMapper, UserBase> implements UserBaseService {
    @Resource
    private UserBaseMapper userBaseMapper;

    @Override
    @Transactional
    public UserBase lockSelect(Integer id) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UserBase userBase = userBaseMapper.lockSelect(id);
        return userBase;
    }
}
