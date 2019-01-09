package com.myretail.api.controller;

import com.myretail.api.model.ProductPrice;
import com.myretail.api.model.Product;
import com.myretail.api.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping("/products")
    public List<Product> getAllProducts() {
        return Arrays.asList(
                new Product(0L, "Product 1", new ProductPrice()),
                new Product(2L, "Product 2", new ProductPrice()),
                new Product(4L, "Product 4", new ProductPrice())
        );
    }

    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    Product getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }
}
