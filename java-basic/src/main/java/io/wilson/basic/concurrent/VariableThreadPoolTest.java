package io.wilson.basic.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ex_hewx
 * @date 2020/8/5
 */
public class VariableThreadPoolTest {
    static final VariableThreadPoolTest test = new VariableThreadPoolTest();

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("thread-%s")
                // execute()执行过程中出现异常则抛出异常线程及异常信息
                .setUncaughtExceptionHandler((thread, throwable) -> {
                    System.err.println("exception thread id:" + thread.getId() + ", thread name:" + thread.getName());
                    throwable.printStackTrace();
                })
                .build();
        ScheduledThreadPoolExecutor executorService = new ScheduledThreadPoolExecutor(5, threadFactory);
        executorService.execute(() -> System.out.println(1));

      /*  ScheduledFuture runFuture = executorService.schedule(() -> System.out.println("run delay 3s print"), 3, TimeUnit.SECONDS);
        ScheduledFuture callFuture = executorService.schedule(() -> "call delay 3s print", 3, TimeUnit.SECONDS);
        executorService.schedule(() -> System.out.println("run delay 5s print"), 5, TimeUnit.SECONDS);
        executorService.schedule(() -> System.out.println("run delay 6s print"), 6, TimeUnit.SECONDS);
        executorService.schedule(() -> System.out.println("run delay 7s print"), 7, TimeUnit.SECONDS);
        executorService.schedule(() -> System.out.println("run delay 9s print"), 9, TimeUnit.SECONDS);
        // 延迟3s启动, 即使每次任务睡眠1s, 所以每次任务的输出间隔依旧为2s，输出时间点为3s、5s、7s、9s
        executorService.scheduleAtFixedRate(() -> {
            try {
                System.out.println("scheduleAtFixedRate");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 3, 2, TimeUnit.SECONDS);
        // 延迟3s启动, 由于每次任务睡眠1s, 所以每次任务的输出间隔实际为3s，输出时间点为3s、6s、9s
        executorService.scheduleWithFixedDelay(() -> {
            try {
                System.out.println("scheduleWithFixedDelay");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 3, 2, TimeUnit.SECONDS);
        Thread.sleep(10000);
        System.err.println("shutdown ScheduledThreadPoolExecutor");
        System.out.println("runFuture: " + runFuture.get() + ", call future:" + callFuture.get());*/
        executorService.shutdown();
    }
}
