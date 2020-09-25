package io.wilson.basic.proxy.aspectJ;

import java.lang.annotation.*;

/**
 * @author Wilson
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAspect {

}
