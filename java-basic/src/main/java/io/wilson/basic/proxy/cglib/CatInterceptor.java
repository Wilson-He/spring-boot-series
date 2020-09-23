package io.wilson.basic.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.commons.lang3.RandomUtils;

import java.lang.reflect.Method;

/**
 * CatInterceptor
 *
 * @author Wilson
 * @date 2020/9/12
 */
public class CatInterceptor implements MethodInterceptor {
    /**
     * 所有生成的代理方法都调用此方法，而不是原始方法。
     * 原始方法既可以通过使用Method对象的常规反射来调用，也可以通过使用MethodProxy（更快）来调用。
     *
     * @param obj    被增强的对象
     * @param method 拦截的方法
     * @param args   方法参数
     * @param proxy  用于方法调用的代理
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // 调用代理实例的父类方法，即代理目标类Cat的方法
        Object result = proxy.invokeSuper(obj, args);
        // 返回增强处理
        return result + "! Wow, 居然跳了" + RandomUtils.nextInt(1, 6) + "米高！";
    }
}
