package io.mybatis.plus.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Wilson-He
 * @date 2020/4/27
 */
@AllArgsConstructor
@Getter
public enum State {
    YES("YES"),
    NO("NO");

    private String val;
}
