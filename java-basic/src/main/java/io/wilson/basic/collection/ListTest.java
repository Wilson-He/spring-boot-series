package io.wilson.basic.collection;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wilson-He
 * @date 2020/7/28
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> arrayList = Lists.newArrayList("1","2","3","4","5");
        List<String> linkedList = Lists.newLinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
/*        new Thread(() -> arrayList.forEach(e ->
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        })).start();
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            arrayList.remove("5");
        }).start();*/
        new Thread(() -> linkedList.forEach(e ->
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(e);
        })).start();
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            linkedList.remove(2);
        }).start();
    }
}
