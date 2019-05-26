package io.github.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ParameterExceptionHandler-参数校验异常拦截器
 *
 * @author Wilson
 */
//@Configuration
//@ControllerAdvice
//@RestControllerAdvice
public class ParameterExceptionHandler {

    private String messageFormat = "%s%s";

    /**
     * body参数校验错误处理
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object postParamExceptionHandler(MethodArgumentNotValidException exception) {
        FieldError fieldError = exception.getBindingResult().getFieldError();
        String message = fieldError.getDefaultMessage();
        // 获取校验对象
        System.err.println("getTarget:" + exception.getBindingResult().getTarget().getClass());
        // 遍历输出校验失败信息
        exception.getBindingResult().getFieldErrors()
                .forEach(e -> System.out.println(e.getField() + " " + e.getDefaultMessage()));
        return msg(message.endsWith(";")
                ? String.format("%s%s", fieldError.getField(), message.substring(0, message.length() - 1)) : message);
    }

    /**
     * query参数校验错误处理
     */
    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity getParamExceptionHandler(ConstraintViolationException exception) {
        ConstraintViolation first = new ArrayList<>(exception.getConstraintViolations()).get(0);
        // 获取校验失败方法所在类
        System.out.println("first.getRootBeanClass():" + first.getRootBeanClass());
        // 获取失败的参数路径，toString()后格式为method.parameterName
        System.out.println("first.getPropertyPath():" + first.getPropertyPath());
        // 失败信息
        System.out.println("first.getMessage():" + first.getMessage());
        // 信息模板，对应ValidationMessages.properties的属性名
        System.out.println("first.getMessageTemplate():" + first.getMessageTemplate());
        return msg(String.format(messageFormat, first.getPropertyPath().toString().split("\\.")[1], first.getMessage()));
    }

    private ResponseEntity msg(Object msg) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", HttpStatus.BAD_REQUEST.value());
        map.put("msg", msg);
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

}
