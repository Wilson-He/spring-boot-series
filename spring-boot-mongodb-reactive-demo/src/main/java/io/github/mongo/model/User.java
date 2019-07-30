package io.github.mongo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author: Wilson
 * @date: 2019/4/29
 **/
@Data
@Document
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private String name;
    private Integer age;
    private String phone;
}
