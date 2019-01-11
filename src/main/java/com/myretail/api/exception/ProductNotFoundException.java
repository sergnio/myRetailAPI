package com.myretail.api.exception;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(int id) {
        super("Product id: " + id + " not found");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
