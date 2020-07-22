package io.wilson.basic;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ex_hewx
 * @date 2020/7/14
 */
public class ObjectLayoutTest {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        LongVO lockVO = new LongVO(5);
        System.err.println("--------------------unlock vo--------------------");
        System.out.println(ClassLayout.parseInstance(lockVO).toPrintable());
        Thread.sleep(100);
        System.err.println("--------------------lock vo--------------------");
        lockVO.lock();
    }
}
