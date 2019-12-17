package io.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.mybatis.plus.entity.UserDetail;
import io.mybatis.plus.mapper.UserDetailMapper;
import io.mybatis.plus.service.UserDetailService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Wilson
 * @since 2019-04-22
 */
@Service
public class UserDetailServiceImpl extends ServiceImpl<UserDetailMapper, UserDetail> implements UserDetailService {

}
