package io.github.ds.service;

import io.github.ds.domain.entity.UserBase;

import java.util.List;

/**
 * <p>
 * UserBase-业务接口
 * </p>
 *
 * @author
 * @since 2019-07-10
 */
public interface UserBaseService {
    List<UserBase> list();

    List<UserBase> selectList();
}
