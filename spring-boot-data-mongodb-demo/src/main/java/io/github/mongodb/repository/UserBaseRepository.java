package io.github.mongodb.repository;

import io.github.mongodb.model.UserBase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author Wilson
 * @date 2019/7/29
 **/
public interface UserBaseRepository extends MongoRepository<UserBase, String>, QuerydslPredicateExecutor<UserBase> {
}
