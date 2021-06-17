package com.example;

import java.lang.String;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JourneyThroughHealthApplication {

    public static void main(String[] args) {
        SpringApplication.run(JourneyThroughHealthApplication.class, args);
    }

}
