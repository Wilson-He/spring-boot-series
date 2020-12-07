package io.wilson.basic.concurrent.model;

/**
 * @author Wilson
 */
public class NestSyncTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Thread a = new Thread(() -> {
            synchronized (calculator) {
                System.out.println("Thread a hold calculator");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread a release calculator");
            }
        });
        Thread b = new Thread(() -> {
            synchronized (calculator) {
                System.out.println("Thread b hold calculator Plus");
                System.out.println(calculator.getPlus().sum(1,2));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread b release calculator");
            }
        });
        a.start();
        b.start();
    }
}
