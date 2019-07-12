package io.github.webflux;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: Wilson
 * @date: 2019/4/29
 **/
public interface UserConstant {
    String OR = "||";

    @AllArgsConstructor
    @Getter
    enum IsDelete {
        /**
         * 已删除
         */
        YES("1"),
        NO("0");
        private String value;
        public static final String PATTERN = YES.value + OR + NO.value;

        public String value() {
            return value;
        }

    }
}
