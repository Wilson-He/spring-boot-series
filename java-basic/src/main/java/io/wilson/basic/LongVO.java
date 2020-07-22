package io.wilson.basic;

import lombok.*;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ex_hewx
 * @date 2020/7/17
 */
@Getter
@Setter
@NoArgsConstructor
public class LongVO {
    private long val;
    ReentrantLock reentrantLock = new ReentrantLock();

    public LongVO(long val) {
        this.val = val;
    }

    public void lock() {
        reentrantLock.lock();
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
        reentrantLock.unlock();
    }
}
