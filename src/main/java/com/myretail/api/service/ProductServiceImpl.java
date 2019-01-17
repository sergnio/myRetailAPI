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

        return new ProductDTO(id, name, productPriceDTO);
    }

}


