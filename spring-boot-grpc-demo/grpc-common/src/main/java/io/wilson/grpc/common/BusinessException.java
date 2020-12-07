package io.wilson.grpc.common;

import io.wilson.grpc.common.aspect.CodeMsg;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * @author Wilson
 */
@ToString
@Getter
public class BusinessException extends RuntimeException {
    private final Integer code;
    private final String msg;

    private final static BusinessException SERVER_EXCEPTION = new BusinessException(CodeMsg.ERROR);

    public BusinessException(CodeMsg codeMsg) {
        //super(Status.fromCode(Status.Code.INTERNAL)
        //        .withDescription(codeMsg.getMsg()));
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }


    public String getStatus() {
        return String.valueOf(code);
    }

    public static void main(String[] args) {
        isInstanceOf(new BusinessException(CodeMsg.BAD_REQUEST), BusinessException.class);
    }

    public static void isInstanceOf(Object source, Class<?> target) {
        System.out.println(target.isInstance(source));
    }

    public static BusinessException serverException() {
        return SERVER_EXCEPTION;
    }

}
