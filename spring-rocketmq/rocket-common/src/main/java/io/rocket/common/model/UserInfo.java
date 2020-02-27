package io.rocket.common.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Wilson
 * @since 2020/2/27
 **/
@Data
@Accessors(chain = true)
public class UserInfo {
    private String id;
    private String name;
}
