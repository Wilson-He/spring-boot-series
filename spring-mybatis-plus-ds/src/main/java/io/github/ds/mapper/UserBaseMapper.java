package io.github.ds.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.ds.domain.entity.UserBase;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author
 * @since 2019-07-10
 */
public interface UserBaseMapper extends BaseMapper<UserBase> {
    @Select("select * from user_base")
    List<UserBase> list();
}
