package io.wilson.basic.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * TempLock
 *
 * @author Wilson
 * @date 2020/8/14
 */
public class TempLock {
    private static final ReentrantLock FAIR_LOCK = new ReentrantLock(true);

    public static void main(String[] args) {
        FAIR_LOCK.lock();
        System.out.println("aaa");
        FAIR_LOCK.unlock();
    }
}
