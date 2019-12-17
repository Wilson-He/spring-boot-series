package io.mybatis.plus;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Wilson
 * @date: 2019/5/10
 **/
@Component
public class BatchSqlInjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList() {
        List<AbstractMethod> methodList = super.getMethodList();
        return super.getMethodList();
    }
}
