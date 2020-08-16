package io.wilson.basic.concurrent;

import java.lang.reflect.Field;

/**
 * @author Wilson-He
 * @date 2020/7/30
 */
public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> test("abc", false));
        t.start();
        t.join();
        System.out.println("--gc后--");
        Thread t2 = new Thread(() -> test("def", true));
        t2.start();
        t2.join();
    }

    private static void test(String s, boolean isGC) {
        try {
            ThreadLocal threadLocal = new ThreadLocal();
            threadLocal.set(s);
            threadLocal.set("ddd");
            if (isGC) {
                System.gc();
            }
            Thread t = Thread.currentThread();
            Class<? extends Thread> clz = t.getClass();
            // 获取线程的ThreadLocal.ThreadLocalMap
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object threadLocalMap = field.get(t);
            // 获取ThreadLocalMap.Entry table[]
            Class<?> tlmClass = threadLocalMap.getClass();
            Field tableField = tlmClass.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] arr = (Object[]) tableField.get(threadLocalMap);
            int i = 0;
            for (Object o : arr) {
                if (o != null) {
                    ++i;
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referenceField.setAccessible(true);
                    System.out.println(String.format("弱引用key:%s,值:%s", referenceField.get(o), valueField.get(o)));
                }
            }
            System.err.println("arr.length:" + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
