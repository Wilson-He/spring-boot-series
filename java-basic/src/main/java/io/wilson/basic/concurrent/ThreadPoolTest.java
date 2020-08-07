package io.wilson.basic.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author Wilson-He
 * @date 2020/7/30
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建线程池工厂设置线程名称格式，execute()任务异常处理器
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("thread-%s")
                // execute()执行过程中出现异常则抛出异常线程及异常信息
                .setUncaughtExceptionHandler((thread, throwable) -> {
                    System.err.println("exception thread id:" + thread.getId() + ", thread name:" + thread.getName());
                    throwable.printStackTrace();
                })
                .build();
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(5, 10, 1,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), threadFactory);
        // 接收Callable结果
        List<Future<String>> futures = new ArrayList<>();
        try {
            // 控制台可能会打印"线程池已满"
            executorService.submit(() -> System.out.println(1 / 0));
            IntStream.range(0, 24)
                    .forEach(i -> executorService.execute(() -> {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }));

            // 提交Callable任务
            // IntStream.range(0, 23)
            //         .forEach(i -> futures.add(executorService.submit(() -> Thread.currentThread().getName())));
        } catch (RejectedExecutionException e) {
            System.err.println("线程池已满");
        } finally {
            // 关闭线程池，避免处理策略抛出的异常导致线程池关闭失败
            executorService.shutdown();
        }
        // 线程池状态若非TERMINATED则自旋阻塞主线程
        while (!executorService.isTerminated()) {

        }
        for (Future<String> fut : futures) {
            try {
                System.out.println(new Date() + "::" + fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
