package org.example.spring_boot_lesson.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class CustomApplicationConfiguration {

    @PostConstruct
    public void init() {
        log.warn("Application configuration loaded");
    }

}
