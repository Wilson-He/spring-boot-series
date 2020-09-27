package io.wilson.basic.proxy.aspectJ;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Wilson
 */
@Aspect
@Component
public class LogAspectWeaver {

    @Pointcut("@annotation(io.wilson.basic.proxy.aspectJ.LogAspect) && execution(* io.wilson.basic.proxy.aspectJ..*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String animal = joinPoint.getSourceLocation().getWithinType().getSimpleName();
        System.out.println("What does the " + animal + " want to do ?");
        Object result = joinPoint.proceed();
        System.out.println("It's barking at you");
        return result;
    }
}
