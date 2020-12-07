package io.springboot.aop.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Wilson
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(LogPointcut)")
    public void pointcut() {
    }


    @AfterThrowing(value = "pointcut()", throwing = "exception")
    public void exceptionHandler(BusinessException exception) {
        System.err.println(exception);
        log.error(exception.getMsg());
    }
}
