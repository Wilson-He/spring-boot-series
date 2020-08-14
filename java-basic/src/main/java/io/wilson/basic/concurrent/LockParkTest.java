package io.wilson.basic.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * LockParkTest
 *
 * @author Wilson
 * @date 2020/8/12
 */
public class LockParkTest {
    public static void main(String[] args) throws InterruptedException {
        LockParkModel model = new LockParkModel();
        Thread thread = new Thread(() -> {
            model.parkHere();
            System.out.println("thread escape park");
        });
        thread.start();
        Thread.sleep(5000);
        LockSupport.unpark(thread);
        Thread waitThread = new Thread(() -> {
            System.out.println(Thread.currentThread() + "thread start");
            try {
                model.waitHere();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "thread end");
        });
        waitThread.start();
        // 主线程等待3秒后唤醒waitThread线程
        Thread.sleep(3000);
        System.out.println("3秒钟的等待结束，进行唤醒");
        synchronized (model) {
            model.notify();
        }
    }
}
