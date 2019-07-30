package io.github.mongodb.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.mongodb.morphia.annotations.Entity;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Wilson
 * @date 2019/7/29
 **/
@Data
@Document("user_base")
@Entity
@Accessors(chain = true)
public class UserBase {
    private String id;
    private String name;
}
