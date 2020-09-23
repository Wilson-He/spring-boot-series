package io.wilson.basic.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * AnimalInvocationHandler
 *
 * @author Wilson
 * @date 2020/9/5
 */
public class AnimalInvocationHandler implements InvocationHandler {
    private Animal animal;

    public AnimalInvocationHandler(Animal animal) {
        this.animal = animal;
    }

    /**
     * 代理对象方法调用
     *
     * @param proxy  根据代理目标类创建的代理Proxy实例ProxyX
     * @param method 与在代理实例上调用的接口方法相对应的Method实例。
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(animal, args);
        System.out.println("Animal代理增加：" + animal.getClass().getName() + result + ", 该代理由Proxy动态子类" + proxy.getClass().getName() + "负责");
        return result;
    }
}
