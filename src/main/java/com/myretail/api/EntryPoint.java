package com.myretail.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Initialize our spring boot application on the App entry point
@SpringBootApplication
public class EntryPoint {
    public static void main(String[] args) {
        // Sets up default configuration, starts spring application, performs class path scan and starts tomcat server.
        SpringApplication.run(EntryPoint.class, args);
    }
}
