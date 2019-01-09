package com.myretail.api.service;

import com.myretail.api.dao.CurrentPrice;
import com.myretail.api.dao.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product findById(Long id) {
        // Make DB calls here
        return new Product(id, "Product 1", new CurrentPrice());
    }
}
