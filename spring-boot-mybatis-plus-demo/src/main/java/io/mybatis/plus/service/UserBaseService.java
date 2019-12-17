package io.mybatis.plus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.mybatis.plus.entity.UserBase;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Wilson
 * @since 2019-04-22
 */
public interface UserBaseService extends IService<UserBase> {
    UserBase lockSelect(Integer id);

}
