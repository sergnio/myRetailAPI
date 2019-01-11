package com.myretail.api.service;

import com.myretail.api.exception.ProductNotFoundException;
import com.myretail.api.model.Product;
import com.myretail.api.model.ProductPrice;

import java.util.List;

public interface ProductService {
    /**
     * Find product by id
     * @param id product id
     * @return a product
     */
    Product findById(int id) throws ProductNotFoundException;

    List<ProductPrice> findAll();

    ProductPrice updateById(int id, ProductPrice productPrice);
}
