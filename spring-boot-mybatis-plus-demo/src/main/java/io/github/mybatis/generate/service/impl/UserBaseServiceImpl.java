package io.github.mybatis.generate.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.mybatis.generate.entity.UserBase;
import io.github.mybatis.generate.mapper.UserBaseMapper;
import io.github.mybatis.generate.service.UserBaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
