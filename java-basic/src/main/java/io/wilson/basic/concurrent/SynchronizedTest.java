package io.wilson.basic.concurrent;

import io.wilson.basic.LongVO;
import lombok.Getter;
import org.openjdk.jol.info.ClassLayout;

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Wilson-He
 * @date 2020/7/22
 */
public class SynchronizedTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        SynCalculate synCalculate = new SynCalculate();
        System.out.println(synCalculate.sum);
    }

    @Getter
    public static class SynCalculate {
        private int sum = 0;

        public void increment() {
            synchronized (this) {
                sum++;
            }
        }
    }
}
