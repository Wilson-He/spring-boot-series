package io.github.mongo.controller;

import io.github.mongo.model.User;
import org.junit.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author: Wilson
 * @date: 2019/4/29
 **/
public class UserControllerTest {
    @Test
    public void findAll() throws InterruptedException {
        WebClient webClient = WebClient.create("http://localhost:8080");
        Mono<String> resp = webClient
                .get().uri("/user/")
                .retrieve()
                .bodyToMono(String.class);
        resp.subscribe(System.out::println);
    }

    @Test
    public void findAll2() throws InterruptedException {
        WebClient webClient = WebClient.create("http://localhost:8080");
        webClient
                .get().uri("/user/")
                .exchange()
                .flatMapMany(clientResponse -> clientResponse.bodyToFlux(User.class))
                .doOnNext(System.err::println)
                .take(1)
                .subscribe();
        Thread.sleep(200);
    }
}
