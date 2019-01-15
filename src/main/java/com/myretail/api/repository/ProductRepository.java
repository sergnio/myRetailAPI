package com.myretail.api.repository;

import com.myretail.api.model.ProductPriceDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interface to make CRUD operations to our MongoDB
 */
public interface ProductRepository extends MongoRepository<ProductPriceDTO, Integer> {

    ProductPriceDTO findById(int id);
}
