package io.github.mongo.controller;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Wilson
 * @date: 2019/4/29
 **/
public class ReactorApiTest {
    @Test
    public void sink() throws InterruptedException {
        final AtomicInteger count = new AtomicInteger(1);
//        Flux.generate(sink -> {
//            sink.next(count.get() + " : " + new Date());
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (count.getAndIncrement() >= 5) {
//                sink.complete();
//            }
//        }).subscribe(System.out::println);
        Flux.create(sink -> {
            sink.next(count.get() + " : " + new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count.getAndIncrement() >= 10) {
                sink.complete();
            }
        })
                .subscribe(System.out::println);
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void testScheduling() {
        Flux.range(0, 10)
                .log()
                .publishOn(Schedulers.newParallel("myParallel"))
//                .log()
                .subscribeOn(Schedulers.newElastic("myElastic"))
//                .log()
                .blockLast();
    }

}
