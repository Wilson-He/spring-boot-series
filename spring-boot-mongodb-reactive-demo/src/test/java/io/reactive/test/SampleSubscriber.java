package io.reactive.test;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

/**
 * @author Wilson-He
 * @date 2020/4/30
 */
public class SampleSubscriber<T> extends BaseSubscriber<T> {
    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("SampleSubscriber subscribe hook");
        request(1);
//        super.hookOnSubscribe(subscription);
    }

    @Override
    public void hookOnNext(T value) {
        System.out.println("value:" + value);
        request(1);
    }

    @Override
    protected void hookOnComplete() {
        System.out.println("SampleSubscriber hookOnComplete");
        super.hookOnComplete();
    }
}
