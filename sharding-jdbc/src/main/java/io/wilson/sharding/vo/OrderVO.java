package io.wilson.sharding.vo;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.springframework.common.utils.ObjectUtils;
import io.springframework.common.validation.group.InsertGroup;
import io.springframework.common.validation.group.UpdateGroup;
import io.swagger.annotations.ApiModelProperty;
import io.wilson.sharding.domain.OrderInfo;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Wilson
 * @since 2020/1/13
 **/
@Data
public class OrderVO {
    @NotNull(groups = UpdateGroup.class)
    private Long id;
    @NotBlank(groups = InsertGroup.class)
    private String username;
    private String note;
    private static final String VERSION = "1.0";
    @Min(0)
    @NotNull(groups = InsertGroup.class)
    @JsonIgnore
    private Long userId;

    public OrderInfo orderInfo() {
        return ObjectUtils.copyProperties(this, new OrderInfo());
    }
}
