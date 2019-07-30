package io.github.webflux;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: Wilson
 * @date: 2019/4/28
 **/
@Slf4j
public class ReactiveDemo {
    public static void main(String[] args) throws InterruptedException {
//        zip();
//        testSyncToAsync();
//        retry();
        subscribe();
    }

    private static void subscribe() throws InterruptedException {
        Flux.range(1, 6)
                .doOnRequest(n -> log.info("Request " + n + " values..."))
                .publish(2)
                .subscribe(new BaseSubscriber<Integer>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        log.info("Subscribed and make a request...");
                        request(1);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            log.error("error", e);
                            Thread.currentThread().interrupt();
                        }
                        log.info("Get value [" + value + "]");
                        request(2);
                    }
                });
    }

    private static void zip() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        String desc = "Zip two sources together";
        Flux.fromArray(desc.split("\\s+"))
                .zipWith(Flux.interval(Duration.ofMillis(2000)))
                .subscribe(tuple -> System.out.println(tuple.getT1()), null, countDownLatch::countDown);
        countDownLatch.await(20, TimeUnit.SECONDS);
    }

    private static void test() {
        Flux colorFlux = Flux.just("red", "white", "blue")
                .log()
                .map(String::toUpperCase)
                .subscribeOn(Schedulers.newParallel("sub"))
                .publishOn(Schedulers.newParallel("pub"), 2)
                .take(1);
        colorFlux.subscribe();
        System.out.println(StepVerifier.create(colorFlux)
                .expectNext("RED", "WHITE", "BLUE")
                .verifyComplete());
        StepVerifier.create(Mono.error(new Exception("some error")))
                .expectErrorMessage("some error")
                .verify();
    }

    private static String getStringSync() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello, Reactor!";
    }

    private static void testSyncToAsync() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Mono.fromCallable(ReactiveDemo::getStringSync)
                .subscribeOn(Schedulers.elastic())
                .subscribe(System.out::println, null, countDownLatch::countDown);
        countDownLatch.await(10, TimeUnit.SECONDS);
    }

    private static void retry() throws InterruptedException {
        Flux.range(1, 6)
                .map(i -> 10 / (3 - i))
                .retry(1)
                .subscribe(System.out::println, System.err::println);
        // 确保序列执行完
        Thread.sleep(100);
    }
}
