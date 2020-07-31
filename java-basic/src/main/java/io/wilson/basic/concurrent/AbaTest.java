package io.wilson.basic.concurrent;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Wilson-He
 * @date 2020/7/31
 */
public class AbaTest {
    public static void main(String[] args) {
        Unsafe unsafe = Unsafe.getUnsafe();
    }


    public static void abaAtomicInteger() {
        AtomicInteger var = new AtomicInteger(1);
        new Thread(() -> {
            int valA = var.get();
            System.out.println("线程1获取到var的值A：" + valA);
            try {
                // 发呆一会让其它线程乘虚而入
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1更新结果：" + var.compareAndSet(valA, ++valA) + "，结果值:" + var.get());
        }).start();
        new Thread(() -> {
            int valA = var.get();
            System.out.println("线程2获取到var的值A：" + valA);
            int valB = valA + 1;
            System.out.println("线程2第一次更新var结果值为B：" + valB + "，结果：" + var.compareAndSet(valA, valB));
            System.out.println("线程2第二次更新var结果值为A：" + valA + "，结果：" + var.compareAndSet(valB, valA));
        }).start();
    }
}
