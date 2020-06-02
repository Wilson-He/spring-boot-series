package io.mybatis.plus.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ex_hewx
 * @date 2020/4/27
 */
@AllArgsConstructor
@Getter
public enum State {
    YES("YES"),
    NO("NO");

    private String val;
}
