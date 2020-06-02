package io.github.mongo.vo;

import org.springframework.beans.BeanUtils;

import java.util.function.Supplier;

/**
 * @author ex_hewx
 * @date 2020/4/24
 */
public class BaseVO {
    public <T> T copyProperties(Supplier<T> supplier) {
        T target = supplier.get();
        BeanUtils.copyProperties(this, target);
        return target;
    }

    public <T> T copyProperties(T t) {
        BeanUtils.copyProperties(this, t);
        return t;
    }
}
