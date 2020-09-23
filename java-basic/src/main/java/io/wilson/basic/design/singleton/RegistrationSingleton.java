package io.wilson.basic.design.singleton;

/**
 * RegistrationSingleton
 *
 * @author Wilson
 * @date 2020/9/9
 */
public class RegistrationSingleton {

    private RegistrationSingleton() {
    }

    private static class SingletonHolder {
        private static final RegistrationSingleton INSTANCE = new RegistrationSingleton();
    }

    public static RegistrationSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
