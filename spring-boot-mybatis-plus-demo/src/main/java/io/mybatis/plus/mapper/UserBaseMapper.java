package io.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.mybatis.plus.entity.UserBase;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Wilson
 * @since 2019-04-22
 */
public interface UserBaseMapper extends BaseMapper<UserBase> {


    UserBase lockSelect(Integer id);
}
