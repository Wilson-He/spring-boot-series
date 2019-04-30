package io.github.mongo.controller;

import io.github.mongo.model.ContinuousEvent;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author: Wilson
 * @date: 2019/4/29
 **/
public class EventControllerTest {
    @Test
    public void webClientTest4() {
        Flux<ContinuousEvent> eventFlux = Flux.interval(Duration.ofSeconds(1))
                .map(l -> new ContinuousEvent(System.currentTimeMillis(), "message-" + l)).take(5); // 1
        WebClient webClient = WebClient.create("http://localhost:8080");
        webClient
                .post()
                .uri("/event/")
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(eventFlux, ContinuousEvent.class)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

}
