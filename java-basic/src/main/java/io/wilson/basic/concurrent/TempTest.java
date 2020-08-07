package io.wilson.basic.concurrent;

import java.util.concurrent.RunnableScheduledFuture;

/**
 * @author ex_hewx
 * @date 2020/8/6
 */
public class TempTest {

    public static void main(String[] args) {
        int i = 12 >>> 3;
        System.out.println(i);
    }

/*    private void siftUp(int k, RunnableScheduledFuture<?> key) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            RunnableScheduledFuture<?> e = queue[parent];
            if (key.compareTo(e) >= 0)
                break;
            queue[k] = e;
            setIndex(e, k);
            k = parent;
        }
        queue[k] = key;
        setIndex(key, k);
    }*/
}
