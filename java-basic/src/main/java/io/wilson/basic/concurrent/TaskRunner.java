package io.wilson.basic.concurrent;

/**
 * @author ex_hewx
 * @date 2020/7/22
 */
public class TaskRunner {
    private static int number;
    private static boolean ready;

    private static class Reader extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Reader().start();
        number = 42;
        ready = true;
    }
}
