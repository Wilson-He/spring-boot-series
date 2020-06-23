package io.wilson.basic.collection;

import java.util.stream.IntStream;

/**
 * 原子性测试
 *
 * @author ex_hewx
 * @date 2020/6/4
 */
public class AtomicTest {
    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        incrementAtomicTest();
        Thread.sleep(1000);
        System.err.println("result:" + i);
    }

    private static void incrementAtomicTest() {
        IntStream.range(0, 20000)
                .forEach(each -> new Thread(AtomicTest::increment).start());
    }

    private static void increment() {
        System.out.println("read i: " + i);
        i++;
    }
}
/*


class UnSafeCounter {
    protected static int counter = 0;

    public static void addCount() {
        counter++;
        System.out.println(counter);
    }
}*/
