package io.wilson.basic.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownTest
 *
 * @author Wilson
 * @date 2020/8/11
 */
public class CountDownTest {
    public static void main(String[] args) throws InterruptedException {
        int threads = 50;
        CountDownLatch countDownLatch = new CountDownLatch(12);
        ExecutorService threadPool = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < 25; ++i) {
            threadPool.execute(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        if (!countDownLatch.await(5, TimeUnit.SECONDS)) {
            System.err.println("倒计时器强制关闭，仍需" + countDownLatch.getCount() + "个线程才完成计数");
        } else {
            System.out.println("倒计时器计数完成");
        }
        threadPool.shutdown();
    }

    /*private static AbstractQueuedSynchronizer abstractQueuedSynchronizer(CountDownLatch countDownLatch) {
        try {
            Field field = CountDownLatch.class.getDeclaredField("sync");
            field.setAccessible(true);
            return (AbstractQueuedSynchronizer) field.get(countDownLatch);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
