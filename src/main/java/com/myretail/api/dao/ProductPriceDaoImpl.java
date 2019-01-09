package com.myretail.api.dao;

import com.myretail.api.model.ProductPrice;
import com.myretail.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="productPriceDao")
public class ProductPriceDaoImpl implements ProductPriceDao {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductPrice findByProductId(Long id) {
        // Connect to Mongo Here
        System.out.println(productRepository.findById(id));
        return new ProductPrice();
    }
}
