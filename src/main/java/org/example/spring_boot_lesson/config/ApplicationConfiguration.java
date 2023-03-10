package org.example.spring_boot_lesson.config;

import org.example.spring_boot_lesson.conditional.FirstConditional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Conditional(FirstConditional.class)
@Configuration
public class ApplicationConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @PostConstruct
    public void init() {
        LOGGER.warn("Application configuration loaded");
    }

}
