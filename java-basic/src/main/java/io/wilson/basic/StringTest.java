package io.wilson.basic;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Wilson-He
 * @date 2020/7/29
 */
public class StringTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String test = "1a2b3c4d";
        String testB = "1a2b3c4d";
        System.out.println(test == testB);
        System.out.println(test.hashCode());
        Field valField = String.class.getDeclaredField("value");
        valField.setAccessible(true);
        char[] value = (char[]) valField.get(test);
        value[0] = '9';
        System.out.println( test);
        System.out.println( testB);
        System.out.println(test == testB);

    }
}
