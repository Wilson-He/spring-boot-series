package io.wilson.basic.design.singleton;

/**
 * HungrySingleton
 *
 * @author Wilson
 * @date 2020/9/9
 */
public class HungrySingleton {
    /**
     * 在静态初始化器中创建单例实例，通过final保证安全，避免反射更改引用
     */
    private static final HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton() {
        if (singleton != null) {
            throw new RuntimeException("单例类禁止反射创建");
        }
    }

    public static HungrySingleton getInstance() {
        return singleton;
    }
}
