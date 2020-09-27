package io.wilson.basic.proxy.aspectJ;

import java.lang.annotation.*;

/**
 * @author Wilson
 */
@Target({ElementType.METHOD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogPoint {

}
