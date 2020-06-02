package io.github.mongo.handler;

import io.github.mongo.model.UserBase;
import io.github.mongo.repository.UserBaseRepository;
import io.github.mongo.vo.BasePageQueryVO;
import io.github.mongo.vo.UserBaseVO;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class UserBaseHandler {
    @Resource
    private UserBaseRepository repository;
    @Resource
    private ReactiveMongoTemplate reactiveMongoTemplate;

    public Mono<ServerResponse> save(ServerRequest request) {
        Mono<UserBase> user = request.bodyToMono(UserBaseVO.class)
                .map(vo -> vo.copyProperties(UserBase::new))
                .flatMap(repository::save);
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(user, UserBase.class);
    }

    public Mono<ServerResponse> page(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(BasePageQueryVO.class)
                .flatMap(queryVO -> reactiveMongoTemplate.find(buildQuery(queryVO), UserBase.class).collectList())
                .flatMap(userBases -> ServerResponse.ok()
                        .body(Mono.just(userBases), ServerResponse.class));
    }
/*
    public Mono<ServerResponse> list(ServerRequest serverRequest) {
        return reactiveMongoTemplate.find(null,UserBase.class)
                ;
    }*/

    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(UserBase.class)
                .flatMap(userBase -> {
                    Query query = new Query()
                            .addCriteria(Criteria.where("id").is(userBase.getId()));
                    return reactiveMongoTemplate.findAndModify(query, new Update().inc("age", 1), UserBase.class);
                })
                .flatMap(userBase -> ServerResponse.ok().body(Mono.just(userBase), ServerResponse.class));
    }

    public Query buildQuery(BasePageQueryVO queryVO) {
        Query query = new Query();
        query.with(PageRequest.of(queryVO.getPage(), queryVO.getSize()));
        return query;
    }

}
