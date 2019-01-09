package com.myretail.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.myretail.api.repository.ProductRepository;

// Initialize our spring boot application on the App entry point
@SpringBootApplication
public class EntryPoint {

    public static void main(String... args) {
        // Sets up default configuration, starts spring application, performs class path scan and starts tomcat server.
        SpringApplication.run(EntryPoint.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Products found:");
//        for (ProductPrice product : repository.findAll()) {
//            System.out.println(product);
//        }
//
//        Long testid = 395727349L;
//
//        System.out.printf("Products found with id: %s \n", testid);
//        System.out.println(repository.findByProductId(testid));
//    }
}
