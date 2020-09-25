package io.wilson.basic.proxy.jdk;

import javax.swing.plaf.TableHeaderUI;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * ProxyTest
 *
 * @author Wilson
 * @date 2020/9/5
 */
public class ProxyTest {
    public static void main(String[] args) throws InterruptedException {
        jdkProxy();
    }

    private static void jdkProxy(){
        // 保存代理生成的文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        // 创建代理对象
        Fish fish = new Fish();
        // 实现代理调用处理器接口
        InvocationHandler animalHandler = new AnimalInvocationHandler(fish);
        Animal proxyFish = (Animal) Proxy.newProxyInstance(fish.getClass().getClassLoader(), Fish.class.getInterfaces(), animalHandler);
        System.out.println("Proxy0 is a son class of Animal:" + (proxyFish instanceof Animal));
        System.out.println("Proxy0 is a son class of Proxy:" + (proxyFish instanceof Proxy));
        System.out.println("Proxy0 is a son class of Fish:" + (proxyFish instanceof Fish));
        proxyFish.run();
    }
}
