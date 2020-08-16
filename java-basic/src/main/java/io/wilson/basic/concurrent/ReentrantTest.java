package io.wilson.basic.concurrent;

import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantTest
 *
 * @author Wilson
 * @date 2020/8/12
 */
@Data
public class ReentrantTest {
    private final ReentrantLock FAIR_LOCK = new ReentrantLock(true);
    private final ReentrantLock NONFAIR_LOCK = new ReentrantLock(false);
    private static final int OPERATION_SECOND = 100;
    private static final int SET_SECOND = 100;
    private String val;

    public static void main(String[] args) {
        ReentrantTest test = new ReentrantTest();
        Thread threadA = new Thread(null, test::nonfairOperation, "threadA");
        Thread threadB = new Thread(null, test::nonfairOperation, "threadB");
        Thread mutexA = new Thread(null, () -> test.nonfairSetVal("a"), "mutexA");
        Thread mutexB = new Thread(null, () -> test.nonfairSetVal("b"), "mutexB");
        threadA.start();
        threadB.start();
        mutexA.start();
        mutexB.start();
    }

    public void fairOperation() {
        FAIR_LOCK.lock();
        operation();
        FAIR_LOCK.unlock();
    }

    public void operation() {
        try {
            Thread.sleep(OPERATION_SECOND * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setVal(String val) {
        this.val = val;
        try {
            Thread.sleep(SET_SECOND * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fairSetVal(String val) {
        FAIR_LOCK.lock();
        setVal(val);
        System.out.println("fairSetVal, val:" + val + ", thread:" + Thread.currentThread().getName());
        FAIR_LOCK.unlock();
    }

    public void nonfairOperation() {
        NONFAIR_LOCK.lock();
        System.out.println("nonfairOperation, thread: " + Thread.currentThread().getName());
        operation();
        NONFAIR_LOCK.unlock();
    }

    public void nonfairSetVal(String val) {
        NONFAIR_LOCK.lock();
        setVal(val);
        System.out.println("nonfairSetVal, val:" + val + ", thread:" + Thread.currentThread().getName());
        NONFAIR_LOCK.unlock();
    }
}
