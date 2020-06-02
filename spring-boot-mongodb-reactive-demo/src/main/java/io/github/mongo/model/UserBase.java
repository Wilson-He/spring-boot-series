package io.github.mongo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: Wilson
 * @date: 2019/4/29
 **/
@Data
@Document("user_base")
@Accessors(chain = true)
public class UserBase implements Serializable {
    @Id
    private ObjectId id;
    private String username;
    private String name;
    private Integer age;
    private String phone;
    private LocalDateTime expirationTime;
    private List<String> sub;

    public UserBase() {
        this.expirationTime = LocalDateTime.now();
    }
}
