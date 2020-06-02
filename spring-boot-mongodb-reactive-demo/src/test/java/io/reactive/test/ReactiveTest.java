package io.reactive.test;

import io.github.mongo.model.UserBase;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ex_hewx
 * @date 2020/4/30
 */
public class ReactiveTest {
    public static void main(String[] args) {
//        subscribeHook();
//        baseSubscribe();
//        generate();
//        handler();
        Flux<Integer> integerFlux = Flux.just("112", "1123")
                .flatMap(val -> Mono.just(Integer.valueOf(val) - 100));
        integerFlux.subscribe(System.out::println);
        List<Integer[]> arrList = Arrays.asList(new Integer[]{1, 2, 3}, new Integer[]{2, 3, 4});
        List<Integer> integerList = arrList.stream()
                .flatMap(val -> Arrays.stream(val))
                .collect(Collectors.toList());
        System.out.println(integerList);
        List<String> list = Arrays.asList(1, 2, 3)
                .stream()
                .flatMap(number -> Stream.of(number + "|||"))
                .collect(Collectors.toList());
    }

    public static void listTest(){
        List<UserBase> list = new ArrayList<>();
        List<String> subs = list.stream()
                .map(UserBase::getSub)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public static void handler() {
        // sink池是用于记录状态值方便用于下一个元素的操作
        Flux<String> bridge = Flux.just("aaa", "bbb", null, "ccc")
                .filter(Objects::nonNull)
                .handle((str, sink) -> {
                    if (str != null) {
                        sink.next(str.concat("|||"));
                    }
                });
        bridge.subscribe(System.out::println);
        Flux<String> alphabet = Flux.just(-1, 30, 22, 9, 20)
                .handle((i, sink) -> {
                    String letter = Optional.ofNullable(i)
                            .map(ReactiveTest::alphabet)
                            .orElse(null);
                    if (letter != null)
                        sink.next(letter);
                });
        alphabet.subscribe(System.out::println);
    }

    public static String alphabet(int letterNumber) {
        if (letterNumber < 1 || letterNumber > 26) {
            return null;
        }
        int letterIndexAscii = 'A' + letterNumber - 1;
        return "" + (char) letterIndexAscii;
    }


    public static void generate() {
        // sink池是用于记录状态值方便用于下一个元素的操作
        Flux<String> flux = Flux.generate(
                () -> 1,
                (state, sink) -> {
                    System.out.println("state:" + state);
                    sink.next("3 x " + state + " = " + 3 * state);
                    if (state == 10) {
                        sink.complete();
                    }
                    return state + 1;
                }, state -> System.out.println("consume:" + state));
        flux.subscribe(System.out::println);
    }

    public static void baseSubscribe() {
        Flux<String> source = Flux.just("a", "b", "c", "d");
        source.map(String::toUpperCase)
                .subscribe(new BaseSubscriber<String>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        request(1);
                    }

                    @Override
                    protected void hookOnNext(String value) {
                        request(1);
                        System.out.println("hookOnNext:" + value);
                    }

                    @Override
                    protected void hookOnComplete() {
                        System.out.println("hookOnComplete");
                    }

                    @Override
                    protected void hookFinally(SignalType type) {
                        System.out.println("SignalType type:" + type);
                    }
                });


    }

    public static void onError() {
        Flux<Integer> ints = Flux.range(1, 4)
                .map(i -> {
                    if (i <= 3) return i;
                    throw new RuntimeException("error to 4");
                });
        ints.subscribe(System.out::println, System.err::println);
    }

    public static void onComplete() {
        Flux<Integer> ints = Flux.range(1, 4);
        ints.subscribe(i -> System.out.println(i),
                System.err::println,
                () -> System.out.println("Done"));
    }

    public static void subscribeHook() {
        Flux<Integer> ints = Flux.range(1, 4);
        SampleSubscriber subscriber = new SampleSubscriber<Integer>();
        ints.subscribe(System.out::println,
                System.out::println,
                () -> System.out.println("Done"),
                subscription -> subscriber.onSubscribe(subscription));
    }
}
