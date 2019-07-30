package io.github.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.test.domain.entity.Teacher;
import io.github.test.mapper.TeacherMapper;
import io.github.test.service.TeacherService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author
 * @since 2019-05-07
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

}
