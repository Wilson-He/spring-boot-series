package io.github.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author: Wilson
 * @date: 2019/4/29
 **/
@Document(collection = "event")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContinuousEvent {
    private Long id;
    private String message;
}
