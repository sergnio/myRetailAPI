package com.myretail.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Initialize our spring boot application on the App entry point
@SpringBootApplication
public class ApiApp {
    public static void main(String[] args) {
        // Starts the springboot application.
        SpringApplication.run(ApiApp.class, args);
    }
}
