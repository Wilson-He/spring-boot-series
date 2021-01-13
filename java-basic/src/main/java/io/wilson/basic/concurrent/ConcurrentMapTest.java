package io.wilson.basic.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 * @author Wilson-He
 * @date 2020/7/29
 */
public class ConcurrentMapTest {
    public static void main(String[] args) {
        Map<String, String> cmap = new ConcurrentHashMap<>();
        IntStream.range(0, 10)
                .forEach(i -> cmap.put(String.valueOf(i), String.valueOf(i)));
        cmap.values().remove("8");
        cmap.forEach((k,v) -> System.out.println("k:" + k + ", v:" + v));
        System.err.println(cmap.size());

        Map<String, String> map = new HashMap<>();
        IntStream.range(0, 10)
                .forEach(i -> map.put(String.valueOf(i), String.valueOf(i)));
        map.values().remove("8");
        map.forEach((k,v) -> System.out.println("k:" + k + ", v:" + v));
        System.err.println(map.size());

    }
}
