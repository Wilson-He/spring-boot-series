package io.github.mongo.controller;

import io.github.mongo.model.ContinuousEvent;
import io.github.mongo.repository.EventRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author: Wilson
 * @date: 2019/4/29
 **/
@RestController
@RequestMapping("/event")
public class EventController {
    @Resource
    private EventRepository eventRepository;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Void> loadEvents(@RequestBody Flux<ContinuousEvent> events) {
        return this.eventRepository.saveAll(events).then();
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<ContinuousEvent> getEvents() {
        return eventRepository.findBy();
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<ContinuousEvent> findAll() {
        return eventRepository.findAll();
    }

}
