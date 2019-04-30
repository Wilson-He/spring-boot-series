package io.github.mongo.repository;

import io.github.mongo.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @author: Wilson
 * @date: 2019/4/29
 **/
public interface UserRepository extends ReactiveCrudRepository<User, String> {
    /**
     *
     * @param username
     * @return
     */
    Mono<User> findByUsername(String username);
    /**
     *
     * @param username
     * @return
     */
    Mono<User> deleteByUsername(String username);
}
