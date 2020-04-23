package io.mybatis.plus.domain.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * UserBase常量类
 *
 * @author Wilson
 * @since 2020-04-09
 */
public interface UserBaseConstant {

    /**
     * 删除(YES:1-已删除,NO:0-未删除)
     */
    @AllArgsConstructor
    @Getter
    enum IsDelete {
        YES(1, "已删除"),
        NO(0, "未删除");
        private final Integer value;
        private final String comment;
        private static final Map<Integer, String> MAP = Collections.unmodifiableMap(Arrays.stream(IsDelete.values())
                .collect(Collectors.toMap(IsDelete::getValue, IsDelete::getComment)));

        public static String comment(Integer value) {
            return MAP.get(value);
        }

        public boolean equalsVal(Integer val) {
            return this.value.equals(val);
        }
    }

    /**
     * 状态(ENABLE:启用,DISABLE:禁用)
     */
    @AllArgsConstructor
    @Getter
    enum Status {
        ENABLE("ENABLE", "启用"),
        DISABLE("DISABLE", "禁用");
        private String value;
        private String comment;
        private static final Map<String, String> MAP = Collections.unmodifiableMap(Arrays.stream(Status.values())
                .collect(Collectors.toMap(Status::getValue, Status::getComment)));

        public static String comment(String value) {
            return MAP.get(value);
        }

        public boolean equalsVal(String val) {
            return this.value.equals(val);
        }
    }

}
