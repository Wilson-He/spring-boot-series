package io.github.ds.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.ds.domain.entity.OrderBase;
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
public interface OrderBaseMapper extends BaseMapper<OrderBase> {

    @Select("select * from order_base")
    List<OrderBase> list();
}
