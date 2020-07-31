package io.wilson.basic;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wilson-He
 * @date 2020/7/29
 */
public class StringTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String test = "1a2b3c4d";
        System.out.println(test);
        System.out.println(test.hashCode());
        Field valField = String.class.getDeclaredField("value");
        valField.setAccessible(true);
        char[] value = (char[]) valField.get(test);
        value[0] = '9';
        System.out.println(test);
        System.out.println(test.hashCode());

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("abc");
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(123);
        // 输出true说明泛型类型String和Integer都被擦除掉了，只剩下原始类型List
        System.out.println(stringList.getClass() == intList.getClass());

        List<Integer> list = new ArrayList<>();
        list.add(12);
        // 直接添加会报错
        // list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        // 通过反射添加成功
        add.invoke(list, "kl");
        System.out.println(list);
    }
}
