package io.github.mybatis.generate.mapper;

import io.github.mybatis.generate.entity.UserBase;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Wilson
 * @since 2019-04-22
 */
public interface UserBaseMapper extends BaseMapper<UserBase> {


    UserBase lockSelect(Integer id);
}
