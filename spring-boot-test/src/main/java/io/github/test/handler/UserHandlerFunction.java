package io.github.test.handler;

import io.github.test.domain.entity.UserBase;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author: Wilson
 * @date: 2019/4/28
 **/
@Component
public class UserHandlerFunction {

    public Mono<ServerResponse> get(ServerRequest request) {
        return ServerResponse.ok()
                .body(Mono.just(new UserBase().setUsername("Wilson")), UserBase.class);
    }
}
