package io.wilson.basic.design.singleton;

/**
 * DoubleCheckSingleton
 *
 * @author Wilson
 * @date 2020/9/9
 */
public class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton singleton;

    private DoubleCheckSingleton() {
        if (singleton != null) {
            throw new RuntimeException("单例类禁止反射创建");
        }
    }

    public static DoubleCheckSingleton getInstance() {
        if (singleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
