package io.github.mongo;

import io.github.mongo.model.ContinuousEvent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * @author: Wilson
 * @date: 2019/4/29
 **/
@SpringBootApplication
public class MongodbApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class);
    }

    @Bean
    public CommandLineRunner initData(MongoOperations mongo) {
        return (String... args) -> {
            mongo.dropCollection(ContinuousEvent.class);
            mongo.createCollection(ContinuousEvent.class, CollectionOptions.empty().maxDocuments(200).capped());
        };
    }
}
