package com.myretail.api.controller;

import com.myretail.api.dao.CurrentPrice;
import com.myretail.api.dao.Product;
import com.myretail.api.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping("/products")
    public List<Product> getAllProducts() {
        return Arrays.asList(
                new Product(0L, "Product 1", new CurrentPrice()),
                new Product(2L, "Product 2", new CurrentPrice()),
                new Product(4L, "Product 4", new CurrentPrice())
        );
    }

    @GetMapping("/products/{id}")
    Product getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }
}
