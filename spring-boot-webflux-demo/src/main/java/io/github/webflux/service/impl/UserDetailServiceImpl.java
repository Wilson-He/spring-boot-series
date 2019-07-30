package io.github.webflux.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.webflux.entity.UserDetail;
import io.github.webflux.mapper.UserDetailMapper;
import io.github.webflux.service.UserDetailService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Wilson
 * @since 2019-04-28
 */
@Service
public class UserDetailServiceImpl extends ServiceImpl<UserDetailMapper, UserDetail> implements UserDetailService {

}
