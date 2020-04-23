package io.rocket.common.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Wilson
 * @since 2020/2/27
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private Integer id;
    private String name;
}
