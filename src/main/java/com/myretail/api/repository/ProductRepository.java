package com.myretail.api.repository;

import com.myretail.api.model.ProductPriceDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<ProductPriceDTO, Integer> {

    ProductPriceDTO findById(int id);

    ProductPriceDTO save(int id);

    List<ProductPriceDTO> findAll();
}
