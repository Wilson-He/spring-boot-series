package io.web.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.task.TaskSchedulingProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 * @author Wilson
 * @since 2019/12/17
 **/
@SpringBootApplication
// @EnableScheduling
public class SimpleWebApplication {

    @PostConstruct
    public void init() {
        // 每5秒打印一次当前时间
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleWebApplication.class, args);
    }
}
