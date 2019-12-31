package io.mybatis.plus;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;

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

    public static void main(String[] args) {
        String pattern = Lists.newArrayList("aaa", "bbb")
                .stream()
                .reduce((a, b) -> a + "|" + b)
                .orElse("") + "|";
        System.err.println(pattern);
        System.out.println(StringUtils.matches(pattern + "|","bbb"));
    }
}
