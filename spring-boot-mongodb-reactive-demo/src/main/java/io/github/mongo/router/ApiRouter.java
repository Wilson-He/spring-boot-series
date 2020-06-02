package io.github.mongo.router;

import io.github.mongo.handler.UserBaseHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import javax.annotation.Resource;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;

/**
 * @author ex_hewx
 * @date 2020/4/24
 */
@Configuration
public class ApiRouter {
    @Resource
    private UserBaseHandler userBaseHandler;

    @Bean("user-base-router")
    public RouterFunction<ServerResponse> userBaseRoute() {
        return RouterFunctions.route(POST("/user").and(contentType(MediaType.APPLICATION_JSON)), userBaseHandler::save)
                .andRoute(POST("/user/page").and(contentType(MediaType.APPLICATION_JSON)), userBaseHandler::page)
                    .andRoute(POST("/user/update").and(contentType(MediaType.APPLICATION_JSON)), userBaseHandler::update);
    }
}
