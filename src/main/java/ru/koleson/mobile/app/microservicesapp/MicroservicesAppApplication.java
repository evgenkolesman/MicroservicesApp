package ru.koleson.mobile.app.microservicesapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MicroservicesAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesAppApplication.class, args);
    }

}
