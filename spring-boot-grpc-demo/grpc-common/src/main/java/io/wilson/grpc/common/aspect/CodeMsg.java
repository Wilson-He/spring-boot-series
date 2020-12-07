package io.wilson.grpc.common.aspect;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Wilson
 */
@Getter
@AllArgsConstructor
public enum CodeMsg {
    /**
     *
     */
    BAD_REQUEST(400,"服务器参数错误"),
    ERROR(500,"服务器开了点小差");
    private final Integer code;
    private final String msg;
}
