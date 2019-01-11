package com.myretail.api.controller;

import com.myretail.api.exception.ProductNotFoundException;
import com.myretail.api.model.Product;
import com.myretail.api.model.ProductPrice;
import com.myretail.api.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("products/{id}")
    @ResponseStatus(HttpStatus.OK)
    Product getProduct(@PathVariable int id) {
        try {
            Product product = productService.findById(id);
            if (product == null) {
                throw new ProductNotFoundException(id);
            }
            return product;
        } catch (ProductNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
            // Add generic message for general exceptions
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Product id: " + id + " not found on API server", e);
        }
    }

    @PutMapping("/products/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    ProductPrice updateProductPrice(@PathVariable int id, @RequestBody ProductPrice productPrice) {
        productService.updateById(id, productPrice);
        return productPrice;
    }


    @GetMapping("products/")
    @ResponseStatus(HttpStatus.OK)
    List<ProductPrice> getAllProducts() { return productService.findAll(); }
}
