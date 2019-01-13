package com.myretail.api.service;

import com.myretail.api.exception.ProductNotFoundException;
import com.myretail.api.model.ProductPriceDTO;
import com.myretail.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductPriceServiceImpl implements ProductPriceService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void updateById(ProductPriceDTO productPriceDTO) throws ProductNotFoundException {
        if (productRepository.findById(productPriceDTO.getId()) != null) {
            productRepository.save(productPriceDTO);
        } else {
            // Throw an exception if the product id isn't found. Create a POST to create a new product.
            throw new ProductNotFoundException(productPriceDTO.getId());
        }
    }
}
