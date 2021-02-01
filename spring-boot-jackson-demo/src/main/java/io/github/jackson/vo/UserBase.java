package io.github.jackson.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author Wilson
 */
@Data
@JsonInclude
public class UserBase {
    private Long id;
    private String name;

    public UserBase(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
