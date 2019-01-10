package com.myretail.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    private int id;
    private String name;
    // Add JSON Property to match specifications
    // NOTE: We can add JSON Property to the member variable because we aren't trying to match the variables
    // to the database, unlike ProductPrice:getCurrencyCode
    @JsonProperty("current_price")
    private ProductPrice productPrice;

    public Product() {
    }

    public Product(int id, String name, ProductPrice productPrice) {
        this.id = id;
        this.name = name;
        this.productPrice = productPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductPrice getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(ProductPrice productPrice) {
        this.productPrice = productPrice;
    }

}
