package io.wilson.basic.concurrent;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Consumer;

/**
 * @author Wilson
 */
public class CompletableTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> "hello siting", executor)
                .thenAcceptAsync(System.out::println, executor)
                .thenAcceptAsync(unused -> System.out.println(Thread.currentThread().getName()))
                .thenAcceptAsync(unused -> System.out.println(Thread.currentThread().getName()));
        CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()));
        executor.shutdown();

        Thread.sleep(2000);
    }
}
