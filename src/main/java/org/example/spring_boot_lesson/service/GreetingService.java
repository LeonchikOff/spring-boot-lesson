package org.example.spring_boot_lesson.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Value("${app.services.greeting.message}")
    private String greetingMsg;

    public String greeting() {
        return greetingMsg;
    }

}
