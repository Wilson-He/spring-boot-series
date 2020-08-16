package io.wilson.basic.concurrent.model;

import lombok.Data;

import java.util.concurrent.locks.LockSupport;

/**
 * LockModel
 *
 * @author Wilson
 * @date 2020/8/12
 */
@Data
public class LockParkModel {

    public void parkHere() {
        System.out.println("enter park");
        // 挂起当前线程
        LockSupport.park();
        // LockSupport.unpark()唤醒线程后执行
        System.out.println("exit park");
    }

    public void waitHere() throws InterruptedException {
        System.out.println(Thread.currentThread() + "enter LockParkModel wait");
        // 使当前线程等待,需先使用synchronized获取当前对象监视器
        synchronized (this) {
            wait();
        }
        // 其它线程notify当前线程后执行
        System.out.println(Thread.currentThread() + "exit LockParkModel wait");
    }
}
