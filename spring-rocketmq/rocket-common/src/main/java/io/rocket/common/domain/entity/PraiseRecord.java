package io.rocket.common.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 点赞记录表
 * </p>
 *
 * @author 
 * @since 2020-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("点赞记录表")
public class PraiseRecord implements Serializable {
    private Long id;
    private Long uid;
    private Long liveId;
    private LocalDateTime createTime;
}
