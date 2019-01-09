package com.myretail.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// @Document ensures we are querying the 'myretail' collection, instead of the default 'productprice' collection
@Document(collection = "myretail")
public class ProductPrice {

    @Id private int id;
    private double value;
    private String currency_code;

    public ProductPrice() {
    }

    public ProductPrice(int id, double value, String currencyCode) {
        this.id = id;
        this.value = value;
        this.currency_code = currencyCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrencyCode() {
        return currency_code;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currency_code = currencyCode;
    }
}
