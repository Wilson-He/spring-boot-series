package io.github.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.test.domain.entity.UserDetail;
import io.github.test.mapper.UserDetailMapper;
import io.github.test.service.UserDetailService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2019-05-07
 */
@Service
public class UserDetailServiceImpl extends ServiceImpl<UserDetailMapper, UserDetail> implements UserDetailService {

}
