package io.github.mongodb;

import io.github.mongodb.model.UserBase;
import io.github.mongodb.repository.UserBaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.stream.Collectors;

/**
 * @author Wilson
 * @date 2019/7/29
 **/
@SpringBootApplication
public class MongodbApplication {
    @Resource
    private UserBaseRepository userBaseRepository;

    @PostConstruct
    public void init() {
        userBaseRepository.insert(new UserBase().setName("Andy"));
        userBaseRepository.insert(new UserBase().setName("Lily"));
        userBaseRepository.insert(new UserBase().setName("William"));
        userBaseRepository.insert(new UserBase().setName("Tony"));
        userBaseRepository.insert(new UserBase().setName("Tom"));
        System.err.println(userBaseRepository.findAll(PageRequest.of(1, 5)).get().collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }
}
