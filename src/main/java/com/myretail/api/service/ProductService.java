package com.myretail.api.service;

import com.myretail.api.dao.Product;

public interface ProductService {
    Product findById(Long id);

}
