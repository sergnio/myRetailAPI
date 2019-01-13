package com.myretail.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO {

    private int id;
    private String name;
    // Add JSON Property to match specifications
    @JsonProperty("current_price")
    private ProductPriceDTO productPriceDTO;

    public ProductDTO() {
    }

    public ProductDTO(int id, String name, ProductPriceDTO productPriceDTO) {
        this.id = id;
        this.name = name;
        this.productPriceDTO = productPriceDTO;
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

    public ProductPriceDTO getProductPriceDTO() {
        return productPriceDTO;
    }

    public void setProductPriceDTO(ProductPriceDTO productPriceDTO) {
        this.productPriceDTO = productPriceDTO;
    }

}
