package io.github.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author: Wilson
 * @date: 2019/4/29
 **/
@EnableWebFlux
@EnableReactiveMongoRepositories
@SpringBootApplication
public class MongodbApplication {
    @Resource
    private MongoTemplate mongoTemplate;
    @Resource
    private MongoMappingContext mongoMappingContext;


/*    @EventListener(ApplicationReadyEvent.class)
    public void initIndicesAfterStartup() {
        mongoMappingContext.setAutoIndexCreation(true);
        IndexOperations indexOps = mongoTemplate.indexOps(UserBase.class);
        IndexResolver resolver = new MongoPersistentEntityIndexResolver(mongoMappingContext);
        resolver.resolveIndexFor(UserBase.class).forEach(indexOps::ensureIndex);
        System.err.println("initIndicesAfterStartup");
    }*/

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class);
    }
}
