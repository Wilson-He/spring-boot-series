package io.springboot.aop.demo.aspect;

import io.springframework.common.response.ResponseCodeMsg;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Wilson
 */
@AllArgsConstructor
@Getter
public class BusinessException extends RuntimeException {
    private Integer code;
    private String msg;

    public BusinessException(ResponseCodeMsg codeMsg) {
        code = codeMsg.code();
        msg = codeMsg.msg();
    }
}
