package io.wilson.basic.design.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * LazySingleTon
 *
 * @author Wilson
 * @date 2020/9/9
 */
public class LazySingleton {
    private static LazySingleton singleton;

    private LazySingleton() {
        if (singleton != null) {
            throw new RuntimeException("单例类禁止反射创建");
        }
    }

    public static synchronized LazySingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        LazySingleton singleton = LazySingleton.getInstance();
        System.out.println(singleton);
        Constructor constructor = LazySingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        LazySingleton lazySingleton = (LazySingleton) constructor.newInstance();
        System.out.println(lazySingleton);
    }
}
