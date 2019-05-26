package io.github.web.validation.interceptor;

import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * ParameterExceptionHandler-参数校验异常拦截器
 *
 * @author Wilson
 */
@Configuration
@ControllerAdvice
@RestControllerAdvice
public class ParameterExceptionHandler {

    private final static String PATTERN_ARG = "arg\\d+";
    @Value("${web.common.validation.msg-key:msg}")
    private String msgKey;
    @Value("${web.common.validation.code-key:code}")
    private String codeKey;
    @Value("${web.common.validation.msg-locale:en}")
    private String msgLocale;
    private String messageFormat;

    /**
     * 配置校验返回信息
     */
    @Bean
    public SessionLocaleResolver localeResolver() {
        messageFormat = msgLocale.contains("zh") ? "%s%s" : "%s %s";
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(LocaleUtils.toLocale(msgLocale));
        return sessionLocaleResolver;
    }


    /**
     * body参数校验错误处理
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object postParamExceptionHandler(MethodArgumentNotValidException exception) {
        FieldError fieldError = exception.getBindingResult().getFieldError();
        String message = fieldError.getDefaultMessage();
        return msg(message.endsWith(";")
                ? String.format(messageFormat, fieldError.getField(), message.substring(0, message.length() - 1)) : message);
    }

    /**
     * query参数校验错误处理
     */
    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity getParamExceptionHandler(ConstraintViolationException exception) {
        ConstraintViolation first = new ArrayList<>(exception.getConstraintViolations()).get(0);
        String defaultMsg = first.getMessage();
        String end = ";";
        if (!defaultMsg.endsWith(end)) {
            return msg(defaultMsg);
        }
        defaultMsg = defaultMsg.substring(0, defaultMsg.length() - 1);
        // 下标0-请求方法(get,post,put,delete),1-校验出错的参数名
        String[] methodParam = first.getPropertyPath().toString().split("\\.");
        // 编译器可能会把参数编译成arg0、arg1...参数名正常编译则直接返回
        if (!methodParam[1].matches(PATTERN_ARG)) {
            return msg(String.format(messageFormat, methodParam[1], defaultMsg));
        }
        // 参数名为{arg下标}时通过反射获取对应校验出错的参数名称
        // 方法的参数数目
        int paramSize = first.getExecutableParameters().length;
        Method method = Arrays.stream(first.getRootBeanClass().getMethods())
                .filter(e -> e.getParameters().length == paramSize && methodParam[0].equals(e.getName()))
                .findFirst()
                .orElse(null);
        // 校验出错的参数名,methodParam[0]为校验的方法名
        String validationParamName = methodParam[1];
        ParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        List<String> paramNames = Arrays.asList(parameterNameDiscoverer.getParameterNames(method));
        int index = validationParamName.matches(PATTERN_ARG)
                ? Integer.parseInt(StringUtils.substringAfterLast(validationParamName, "arg"))
                : paramNames.indexOf(validationParamName);
        return msg(String.format(messageFormat, paramNames.get(index), defaultMsg));
    }

    private ResponseEntity msg(Object msg) {
        Map<String, Object> map = new HashMap<>(2);
        map.put(codeKey, HttpStatus.BAD_REQUEST.value());
        map.put(msgKey, msg);
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

}
