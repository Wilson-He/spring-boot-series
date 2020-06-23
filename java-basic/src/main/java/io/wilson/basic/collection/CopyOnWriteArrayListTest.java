package io.wilson.basic.collection;

/**
 * @author ex_hewx
 * @date 2020/6/3
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) throws InterruptedException {
        CustomArray<String> list = new CustomArray<>();
        list.add("a");
        list.add("b");
        System.err.println("-------------------------Thread start-----------------------");
        // write不影响读操作，多个write线程之间互相阻塞
        read(list);
        write(list, "cc");
        read(list);
        remove(list, 1);
        write(list, "aa");
        read(list);
        read(list);
        write(list, "bb");
        read(list);
        Thread.sleep(2000);
        System.out.println(list);
    }

    public static void read(CustomArray<String> list) {
        new Thread(() -> {
            StringBuilder builder = new StringBuilder();
            list.forEach(each -> builder.append(each).append(","));
            System.out.println("read thread: " + Thread.currentThread().getId() + ", list: " + builder.deleteCharAt(builder.lastIndexOf(",")));
        }).start();
    }

    public static void write(CustomArray<String> list, String ele) {
        new Thread(() -> list.add(ele)).start();
    }

    public static void remove(CustomArray<String> list, int i) {
        new Thread(() -> list.remove(i)).start();
    }
}
