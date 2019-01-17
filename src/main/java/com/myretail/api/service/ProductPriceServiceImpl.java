package com.myretail.api.service;

import com.myretail.api.exception.ProductNotFoundException;
import com.myretail.api.model.ProductPriceDTO;
import com.myretail.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void updateById(ProductPriceDTO productPriceDTO) throws ProductNotFoundException {
        // First check if the product doesn't exist before we update. Creation is not done here.
        if (productRepository.findById(productPriceDTO.getId()) != null) {
            productRepository.save(productPriceDTO);
        } else {
            // Throw an exception if the product id isn't found. Create a POST to create a new product.
            throw new ProductNotFoundException(productPriceDTO.getId());
        }
    }
}
