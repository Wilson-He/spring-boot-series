package io.github.webflux;

import java.util.EnumSet;

/**
 * @author: Wilson
 * @date: 2019/4/29
 **/
public class ConstantApp {
    public static void main(String[] args) {
        System.out.println(UserConstant.IsDelete.NO.name());
        System.out.println(EnumSet.allOf(UserConstant.IsDelete.class));
    }
}
