package io.wilson.basic.proxy.aspectJ;

import org.springframework.stereotype.Component;

@Component
public class Dog {

    @LogAspect
    public void cry(){
        System.out.println("狗狗汪汪叫");
    }
}
