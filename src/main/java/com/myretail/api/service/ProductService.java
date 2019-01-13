package com.myretail.api.service;

import com.myretail.api.exception.ProductNotFoundException;
import com.myretail.api.model.ProductDTO;
import com.myretail.api.model.ProductPriceDTO;

import java.util.List;

public interface ProductService {
    /**
     * Find product by id
     * @param id product id
     * @return a product
     */
    ProductDTO findById(int id) throws ProductNotFoundException;

    void updateById(ProductPriceDTO productPriceDTO) throws ProductNotFoundException;
}
