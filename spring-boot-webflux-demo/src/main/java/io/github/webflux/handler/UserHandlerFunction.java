package io.github.webflux.handler;

import io.github.webflux.entity.UserBase;
import io.github.webflux.service.UserBaseService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author: Wilson
 * @date: 2019/4/28
 **/
@Component
public class UserHandlerFunction {
    @Resource
    private UserBaseService userBaseService;

    public Mono<ServerResponse> get(ServerRequest request) {
        return ServerResponse.ok()
                .body(Mono.just(userBaseService.getById(Integer.valueOf(request.queryParam("id").orElseThrow(NullPointerException::new)))), UserBase.class);
    }
}
