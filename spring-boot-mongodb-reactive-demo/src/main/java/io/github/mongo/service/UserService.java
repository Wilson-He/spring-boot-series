package io.github.mongo.service;

import io.github.mongo.model.User;
import io.github.mongo.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author: Wilson
 * @date: 2019/4/29
 **/
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public Mono<User> save(User user) {
        return userRepository.save(user)
                .onErrorResume(fallback -> userRepository.findByUsername(user.getUsername())
                        .flatMap(dbUser -> userRepository.save(user.setId(dbUser.getId()))));
    }

    public Mono<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Flux<User> findAll() {
        return userRepository.findAll().log();
    }

    public Mono<Void> delete(String id) {
        return userRepository.deleteById(id);
    }

    public Mono<Void> delete(User user) {
        return userRepository.delete(user);
    }

    public Mono<User> deleteByUsername(String username) {
        return userRepository.deleteByUsername(username);
    }
}
