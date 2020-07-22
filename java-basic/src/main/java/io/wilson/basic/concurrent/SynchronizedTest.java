package io.wilson.basic.concurrent;

import io.wilson.basic.LongVO;

/**
 * @author ex_hewx
 * @date 2020/7/22
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        Object object = new Object();
        synchronized (object){
            System.out.println(object.hashCode());
        }
    }
}
