package com.myretail.api.exception;

/**
 * Exception thrown if we are unable to locate a product within our database or "internal" API
 */
public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(int id) {
        super("ProductDTO id: " + id + " not found");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
