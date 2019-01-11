package com.myretail.api.repository;

import com.myretail.api.model.ProductPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<ProductPrice, Integer> {

    ProductPrice findById(int id);

    ProductPrice save(int id);

    List<ProductPrice> findAll();
}
