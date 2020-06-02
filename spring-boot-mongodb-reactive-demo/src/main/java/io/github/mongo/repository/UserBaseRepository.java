package io.github.mongo.repository;

import io.github.mongo.model.UserBase;
import io.github.mongo.vo.BasePageQueryVO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserBaseRepository extends ReactiveMongoRepository<UserBase,String> {
}
