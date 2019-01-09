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

    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    ProductPrice getProduct(@PathVariable int id) {
        return productService.findById(id);
    }

    @GetMapping("/products/")
    @ResponseStatus(HttpStatus.OK)
    List<ProductPrice> getAllProducts() { return productService.findAll(); }
}
