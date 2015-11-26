package org.guts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class SpringNotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringNotesApplication.class, args);
    }
}
