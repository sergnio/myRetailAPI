package com.myretail.api.service;

import com.myretail.api.exception.ProductNotFoundException;
import com.myretail.api.model.ProductDTO;
import com.myretail.api.model.ProductPriceDTO;
import com.myretail.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RedSkyServiceImpl redSkyService;

    @Override
    public ProductDTO findById(int id) throws ProductNotFoundException {
        ProductPriceDTO productPriceDTO = productRepository.findById(id);
        String name = redSkyService.findProductNameById(id);

        // TODO - check how these microservices are actually done?? JP
        return new ProductDTO(id, name, productPriceDTO);
    }

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


