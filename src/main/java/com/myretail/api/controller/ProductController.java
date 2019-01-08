package com.myretail.api.controller;

import com.myretail.api.model.CurrentPrice;
import com.myretail.api.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {
    @RequestMapping("/products")
    public List<Product> getAllProducts() {
        return Arrays.asList(
                new Product(0, "Product 1", new CurrentPrice()),
                new Product(2, "Product 2", new CurrentPrice()),
                new Product(4, "Product 4", new CurrentPrice())
        );
    }

    @GetMapping("/products/{id}")
    Product one(@PathVariable int id) {
        return new Product(id, "Product 1", new CurrentPrice());
    }
}
