package io.github.mongo.vo;

import lombok.Data;

import java.util.List;

/**
 * @author Wilson-He
 * @date 2020/5/6
 */
@Data
public class BasePageQueryVO {
    private Integer page;
    private Integer size;
    private List<String> sub;
}
