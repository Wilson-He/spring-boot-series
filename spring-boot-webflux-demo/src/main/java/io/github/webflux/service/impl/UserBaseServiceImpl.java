package io.github.webflux.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.webflux.entity.UserBase;
import io.github.webflux.mapper.UserBaseMapper;
import io.github.webflux.service.UserBaseService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Wilson
 * @since 2019-04-28
 */
@Service
public class UserBaseServiceImpl extends ServiceImpl<UserBaseMapper, UserBase> implements UserBaseService {

    public Mono<List<UserBase>> listMono() {
        return Mono.empty();
    }
}
