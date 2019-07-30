package io.github.ds.service.impl;

import io.github.ds.domain.entity.UserBase;
import io.github.ds.ds.DataSource;
import io.github.ds.ds.DataSourceType;
import io.github.ds.mapper.UserBaseMapper;
import io.github.ds.service.UserBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * UserBase-业务接口
 * </p>
 *
 * @author
 * @since 2019-07-10
 */
@Service
public class UserBaseServiceImpl implements UserBaseService {
    @Resource
    private UserBaseMapper userBaseMapper;

    @Override
    @DataSource(DataSourceType.USER)
    public List<UserBase> list() {
        return userBaseMapper.list();
    }

    @Override
    public List<UserBase> selectList() {
        return userBaseMapper.selectList(null);
    }

}
