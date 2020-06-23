package io.wilson.basic.collection;

import java.util.stream.IntStream;

/**
 * @author ex_hewx
 * @date 2020/6/4
 */
public class UnstaticAtomicTest {
    private int i = 0;

    public void increment() {
        System.out.println("i:" + i + ", inc: " + ++i);
    }

    public static void main(String[] args) throws InterruptedException {
        UnstaticAtomicTest unstaticAtomic = new UnstaticAtomicTest();
        IntStream.range(0, 40000)
                .forEach(each -> new Thread(unstaticAtomic::increment).start());
//        IntStream.range(0, 40000)
//                .forEach(each -> unstaticAtomic.increment());
        Thread.sleep(5000);
        System.out.println("result: " + unstaticAtomic.i);
    }
}
