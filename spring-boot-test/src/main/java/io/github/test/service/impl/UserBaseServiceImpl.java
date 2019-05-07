package io.github.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.test.domain.entity.UserBase;
import io.github.test.mapper.UserBaseMapper;
import io.github.test.service.UserBaseService;
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
public class UserBaseServiceImpl extends ServiceImpl<UserBaseMapper, UserBase> implements UserBaseService {

}
