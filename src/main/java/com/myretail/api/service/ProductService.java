package com.myretail.api.service;

import com.myretail.api.model.Product;
import com.myretail.api.model.ProductPrice;

import java.util.List;

public interface ProductService {
    /**
     * Find product by id
     * @param id product id
     * @return a product
     */
    Product findById(int id);

    List<ProductPrice> findAll();
}
