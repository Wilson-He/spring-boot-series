package io.wilson.basic;

import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 * @author ex_hewx
 * @date 2020/8/7
 */
public class StealingThreadPoolTest {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = (ForkJoinPool) Executors.newWorkStealingPool();
        forkJoinPool.execute(() -> System.out.println(1));
        while (forkJoinPool.getActiveThreadCount() > 0){

        }
        forkJoinPool.shutdown();
    }
}
