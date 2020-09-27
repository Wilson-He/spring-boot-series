package io.wilson.basic.proxy.aspectJ;

import org.springframework.stereotype.Component;

@Component
public class Dog {

    @LogPoint
    public void cry(){
        System.out.println("狗狗汪汪叫");
    }
}
