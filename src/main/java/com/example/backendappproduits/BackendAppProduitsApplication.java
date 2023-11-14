package com.example.backendappproduits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication

public class BackendAppProduitsApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendAppProduitsApplication.class, args);
    }
}
