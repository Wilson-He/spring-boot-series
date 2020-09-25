package io.wilson.basic.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import org.springframework.cglib.core.DebuggingClassWriter;

/**
 * CglibTest
 *
 * @author Wilson
 * @date 2020/9/13
 */
public class CglibTest {
    public static void main(String[] args) throws InterruptedException {
        // 设置cglib的调试路径，用于输出代理生成的文件
        String targetPath = CglibTest.class.getResource("/").getPath();
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, targetPath);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Cat.class);
        // 设置代理目标类的拦截器
        enhancer.setCallback(new CatInterceptor());
        Cat proxyCat = (Cat) enhancer.create();
        System.out.println(enhancer.create().getClass());
        System.out.println(proxyCat.jump("Ketty"));
    }
}
