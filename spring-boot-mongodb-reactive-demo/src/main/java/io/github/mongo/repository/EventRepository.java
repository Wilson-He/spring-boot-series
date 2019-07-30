package io.github.mongo.repository;

import io.github.mongo.model.ContinuousEvent;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * @author: Wilson
 * @date: 2019/4/29
 **/
public interface EventRepository extends ReactiveCrudRepository<ContinuousEvent, Long> {
    @Tailable
    Flux<ContinuousEvent> findBy();
}
