package io.github.ds.domain.constant;

import com.google.common.collect.ImmutableBiMap;

import java.util.Map;

/**
 * UserBase常量类
 *
 * @author
 * @since 2019-07-10
 */
public interface UserBaseConstant {

    /**
     * 删除(0-未删除NO,1-已删除YES)
     */
    interface IsDelete {
        /**
         * 未删除
         */
        Integer NO = 0;
        /**
         * 已删除
         */
        Integer YES = 1;
        Map<Integer, String> MAP = ImmutableBiMap.of(
                0, "未删除",
                1, "已删除");
    }

    /**
     * 状态(ENABLE-启用,DISABLE-禁用)
     */
    interface Status {
        /**
         * 启用
         */
        String ENABLE = "ENABLE";
        /**
         * 禁用
         */
        String DISABLE = "DISABLE";
        Map<String, String> MAP = ImmutableBiMap.of(
                "ENABLE", "启用",
                "DISABLE", "禁用");
    }

}
