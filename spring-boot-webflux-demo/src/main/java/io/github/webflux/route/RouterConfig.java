package io.github.webflux.route;

import io.github.webflux.handler.UserHandlerFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author: Wilson
 * @date: 2019/4/28
 **/
@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> userRouter(UserHandlerFunction userHandlerFunction) {
        return RouterFunctions.route(RequestPredicates.GET("/get"), userHandlerFunction::get);
    }
}
