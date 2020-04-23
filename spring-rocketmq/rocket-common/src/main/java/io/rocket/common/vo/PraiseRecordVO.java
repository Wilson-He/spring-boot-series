package io.rocket.common.vo;

import io.springframework.common.vo.BaseVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PraiseRecordVO extends BaseVO {
    private Long uid;
    private Long liveId;
}
