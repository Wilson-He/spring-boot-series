package io.wilson.basic.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @author Wilson-He
 * @date 2020/7/27
 */
public class SetTest {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("1");
        linkedHashSet.add("a");
        linkedHashSet.add("d");
        linkedHashSet.add("c");
        System.out.println(linkedHashSet);
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("1");
        hashSet.add("a");
        hashSet.add("d");
        hashSet.add("c");
        System.out.println(hashSet);
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("d");
        treeSet.add("a");
        treeSet.add("c");
        treeSet.add("1");
        System.out.println(hashSet);
    }


}
