package io.github.test;

import io.github.test.domain.entity.UserBase;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: Wilson
 * @date: 2019/5/7
 **/
@SpringBootApplication
@MapperScan("io.github.test.mapper")
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    public static void schedule() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        executorService.schedule(() -> System.out.println("schedule delay 5s"), 3, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(() -> System.out.println("schedule delay 5s"), 2L,
                2L, TimeUnit.SECONDS);
        executorService.shutdown();
    }

    public static void reference() {
        UserBase userBaseA = new UserBase().setId(11);
        AtomicReference<UserBase> reference = new AtomicReference<>(userBaseA);
        userBaseA.setId(15);
        UserBase userBaseB = new UserBase().setId(111);
        System.out.println(reference.get());
        reference.compareAndSet(userBaseA, userBaseB);
        System.out.println(reference.get());
    }

}
