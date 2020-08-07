package io.wilson.basic.concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Wilson-He
 * @date 2020/7/31
 */
public class CASCounter {
    private Unsafe unsafe;
    private volatile long val = 0;// 字段val在对象实例内存起始地址的偏移量
    private long offset;

    public static void main(String[] args) throws NoSuchFieldException, InterruptedException {
        CASCounter casCounter = new CASCounter();
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0, 1000)
                .forEach(i -> executorService.execute(casCounter::increment));
        executorService.shutdown();
        Thread.sleep(1000);
        System.out.println(casCounter.val);
    }

    private Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public CASCounter() throws NoSuchFieldException {
        unsafe = getUnsafe();
        // objectFieldOffset:获取
        offset = unsafe.objectFieldOffset(CASCounter.class.getDeclaredField("val"));
    }

    public void increment() {
        long oldVal = val;
        while (!unsafe.compareAndSwapLong(this, offset, oldVal, oldVal + 1)) {
            oldVal = val;
        }
    }

    public long getVal() {
        return val;
    }
}
