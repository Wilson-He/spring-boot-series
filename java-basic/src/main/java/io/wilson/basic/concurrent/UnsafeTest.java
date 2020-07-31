package io.wilson.basic.concurrent;

import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Wilson-He
 * @date 2020/7/31
 */
public class UnsafeTest {
    private int number;

    public UnsafeTest() {
        this.number = 1;
    }

    public static void main(String[] args) {
        offHeapTest();
    }

    public static void offHeapTest() {
        // long SUPER_SIZE = (long) Integer.MAX_VALUE * 2;
        long SUPER_SIZE = Integer.MAX_VALUE;
        OffHeapArray array = new OffHeapArray(SUPER_SIZE);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            array.set((long) Integer.MAX_VALUE + i, (byte) 1);
            long each = array.get((long) Integer.MAX_VALUE + i);
            sum += each;
        }
        System.out.println("sum:" + sum + ", array.address:" + array.address + ",array.size():" + array.size() + " ,SUPER_SIZE:" + SUPER_SIZE);
        System.out.println(ClassLayout.parseInstance(array).toPrintable());
        array.freeMemory();
    }

    public static void instanceOperate() throws InstantiationException, NoSuchFieldException {
        Unsafe unsafe = getUnsafe();
        UnsafeTest test = (UnsafeTest) unsafe.allocateInstance(UnsafeTest.class);
        // 输出0
        System.out.println(test.number);
        Field numberField = UnsafeTest.class.getDeclaredField("number");
        unsafe.putInt(test, unsafe.objectFieldOffset(numberField), 1);
        // 输出1
        System.out.println(test.number);
    }


    public static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static class OffHeapArray {
        private final static int BYTE = 1;
        private long size;
        // 内存起始地址
        private long address;

        /**
         * 创建内存数组
         *
         * @param size 分配的内存大小
         */
        public OffHeapArray(long size) {
            this.size = size;
            // 分配内存地址
            address = getUnsafe().allocateMemory(size * BYTE);
        }

        /**
         * 设置起始内存偏移指定下标后的位置值
         *
         * @param i     数组下标，内存偏移量
         * @param value
         */
        public void set(long i, byte value) {
            getUnsafe().putByte(address + i * BYTE, value);
        }

        /**
         * 根据数组下标idx计算在内存中的位置,然后获取数组值
         *
         * @param idx 数组下标，用于计算元素内存相对数组起始地址的偏移量
         * @return
         */
        public int get(long idx) {
            return getUnsafe().getByte(address + idx * BYTE);
        }

        public long size() {
            return size;
        }

        public void freeMemory() {
            getUnsafe().freeMemory(address);
        }
    }
}
