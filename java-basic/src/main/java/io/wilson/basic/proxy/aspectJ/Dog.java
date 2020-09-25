package io.wilson.basic.proxy.aspectJ;

public class Dog {

    @LogAspect
    public void cry(){
        System.out.println("狗狗汪汪叫");
    }
}
