package io.github.mybatis.generate.service.impl;

import io.github.mybatis.generate.entity.UserDetail;
import io.github.mybatis.generate.mapper.UserDetailMapper;
import io.github.mybatis.generate.service.UserDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wilson
 * @since 2019-04-22
 */
@Service
public class UserDetailServiceImpl extends ServiceImpl<UserDetailMapper, UserDetail> implements UserDetailService {

}
