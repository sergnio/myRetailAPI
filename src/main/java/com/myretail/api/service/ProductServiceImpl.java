package com.myretail.api.service;

import com.myretail.api.model.ProductPrice;
import com.myretail.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductPrice findById(int id) {
        // Make DB calls here
        // Also make microservice calls here probably
        return productRepository.findById(id);
    }

    @Override
    public List<ProductPrice> findAll() {
        return productRepository.findAll();
    }

}
