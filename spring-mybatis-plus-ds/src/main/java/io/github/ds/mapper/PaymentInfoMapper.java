package io.github.ds.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.ds.domain.entity.PaymentInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 缴费记录表 Mapper 接口
 * </p>
 *
 * @author
 * @since 2019-07-11
 */
public interface PaymentInfoMapper extends BaseMapper<PaymentInfo> {

    @Select("select * from payment_info")
    List<PaymentInfo> list();
}
