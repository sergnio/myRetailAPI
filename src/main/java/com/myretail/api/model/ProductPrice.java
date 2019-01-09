package com.myretail.api.model;

import org.springframework.data.annotation.Id;

public class ProductPrice {

    @Id
    private Long productId;
    private double value;
    private String currencyCode;

    public ProductPrice() {
    }

    public ProductPrice(Long productId, double value, String currencyCode) {
        this.productId = productId;
        this.value = value;
        this.currencyCode = currencyCode;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
