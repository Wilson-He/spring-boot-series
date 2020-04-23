package io.rocket.common.service;

import io.rocket.common.domain.entity.PraiseRecord;

/**
 * <p>
 * PraiseRecord-点赞记录表业务接口
 * </p>
 * 
 * @author 
 * @since 2020-04-21
 */
public interface PraiseRecordService {
    Long insert(PraiseRecord praiseRecord);

    boolean updateById(PraiseRecord praiseRecord);

    PraiseRecord findById(Long id);

    boolean deleteById(Long id);
}
