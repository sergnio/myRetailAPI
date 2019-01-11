package com.myretail.api.exception;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(int id) {
        super("ProductDTO id: " + id + " not found");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
