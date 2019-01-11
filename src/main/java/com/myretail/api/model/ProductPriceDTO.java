package com.myretail.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

// ensures we are querying the 'productprice' collection
@Document(collection = "productprice")
public class ProductPriceDTO {

    @JsonIgnore
    @Id private int id;
    private double value;
    // Tells Mongo to look for this currency_code, rather than the Java property currencyCode
    @Field("currency_code")
    private String currencyCode;

    public ProductPriceDTO() {
    }

    public ProductPriceDTO(int id, double value, String currencyCode) {
        this.id = id;
        this.value = value;
        this.currencyCode = currencyCode;
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

    // Add JSON Property to match specifications
    @JsonProperty("currency_code")
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
