package io.wilson.basic.collection;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Wilson-He
 * @date 2020/7/28
 */
public class ListTest {
    public static void main(String[] args) throws InterruptedException {
        List<String> arrayList = Lists.newArrayList("1", "2", "3", "4", "5");
        List<String> linkedList = Lists.newLinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("3","3");
        if (linkedList.stream()
                .noneMatch(str -> Optional.ofNullable(str)
                        .map(each -> Objects.equals(str, map.put(each, each)))
                        .orElse(false))) {
            System.out.println(map);
        }
        long a = System.currentTimeMillis();
        Thread.sleep(1000);
        System.out.println(System.currentTimeMillis() - a);
    }
}
