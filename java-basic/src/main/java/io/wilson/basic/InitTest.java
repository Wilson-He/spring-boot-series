package io.wilson.basic;

/**
 * @author Wilson-He
 * @date 2020/7/29
 */
public class InitTest {
    public static void main(String[] args) {
        new Son();
    }

    public static class Parent {
        private static int parNum = 1;

        static {
            System.out.println("parent static block:" + parNum);
        }

        {
            System.out.println("parent block:" + parNum);
        }
    }

    public static class Son extends Parent{
        private static int sonNum = 2;

        static {
            System.out.println("Son static block:" + sonNum);
        }

        {
            System.out.println("son block:" + sonNum);
        }
    }
}
