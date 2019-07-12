package io.github.ds.service.impl;

import io.github.ds.mapper.TeacherMapper;
import io.github.ds.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * Teacher-业务接口
 * </p>
 *
 * @author
 * @since 2019-07-10
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;
}
