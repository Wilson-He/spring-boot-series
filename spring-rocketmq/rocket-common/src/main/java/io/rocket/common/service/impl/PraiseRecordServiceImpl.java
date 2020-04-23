package io.rocket.common.service.impl;

import io.rocket.common.domain.entity.PraiseRecord;
import io.rocket.common.mapper.PraiseRecordMapper;
import io.rocket.common.service.PraiseRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * PraiseRecord-点赞记录表业务接口
 * </p>
 * 
 * @author 
 * @since 2020-04-21
 */
@Service
public class PraiseRecordServiceImpl implements PraiseRecordService{
    @Resource
    private PraiseRecordMapper praiseRecordMapper;

    @Override
    public Long insert(PraiseRecord praiseRecord){
        praiseRecordMapper.insert(praiseRecord);
        return praiseRecord.getId();
    }

    @Override
    public boolean updateById(PraiseRecord praiseRecord){
        return praiseRecordMapper.updateById(praiseRecord) > 0;
    }

    @Override
    public PraiseRecord findById(Long id){
        return praiseRecordMapper.selectById(id);
    }

    @Override
    public boolean deleteById(Long id){
        return praiseRecordMapper.deleteById(id) > 0;
    }
}
