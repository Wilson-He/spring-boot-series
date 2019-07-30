package io.github.test.domain.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * UserBaseConstant
 *
 * @author
 * @since 2019-05-07
 */
public interface UserBaseConstant {
    /**
     * 删除(0-未删除NO,1-已删除YES)
     */
    @AllArgsConstructor
    @Getter
    enum IsDelete {
        /**
         * 未删除
         */
        NO(0),
        /**
         * 已删除
         */
        YES(1);
        private Integer value;
    }

    /**
     * 状态(ENABLE-启用,DISABLE-禁用)
     */
    @AllArgsConstructor
    @Getter
    enum Status {
        /**
         * 启用
         */
        ENABLE("ENABLE"),
        /**
         * 禁用
         */
        DISABLE("DISABLE");
        private String value;
    }

}
