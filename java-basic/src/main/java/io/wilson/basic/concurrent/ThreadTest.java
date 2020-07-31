package io.wilson.basic.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Wilson-He
 * @date 2020/7/30
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        /*for (int i = 0; i < 20; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> System.out.println(finalI));
            thread.start();
            thread.join();
        }*/
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.execute(() -> System.out.println(finalI));
        }
        executorService.shutdown();
        Thread.sleep(1000);
    }
}
