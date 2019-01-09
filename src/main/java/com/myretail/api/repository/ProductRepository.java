package com.myretail.api.repository;

import com.myretail.api.model.ProductPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<ProductPrice, Long> {

    public Optional<ProductPrice> findById(Long productId);
}
