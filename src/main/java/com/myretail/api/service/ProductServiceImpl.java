package com.myretail.api.service;

import com.myretail.api.dao.ProductPriceDaoImpl;
import com.myretail.api.model.ProductPrice;
import com.myretail.api.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductPriceDaoImpl productPriceDao;

    @Override
    public Product findById(Long id) {
        // Make DB calls here
        // Also make microservice calls here probably

        productPriceDao.findByProductId(id);
        return new Product(id, "Product 1", new ProductPrice());
    }
}
