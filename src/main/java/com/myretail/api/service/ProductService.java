package com.myretail.api.service;

import com.myretail.api.model.ProductPrice;

import java.util.List;

public interface ProductService {
    ProductPrice findById(int id);

    List<ProductPrice> findAll();
}
