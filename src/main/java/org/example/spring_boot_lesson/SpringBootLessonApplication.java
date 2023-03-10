package org.example.spring_boot_lesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Conditional;

@SpringBootApplication
public class SpringBootLessonApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootLessonApplication.class, args);
    }
}
