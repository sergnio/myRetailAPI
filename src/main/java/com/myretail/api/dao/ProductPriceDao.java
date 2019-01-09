package com.myretail.api.dao;

import com.myretail.api.model.ProductPrice;
import org.springframework.stereotype.Service;

public interface ProductPriceDao {

    public ProductPrice findByProductId(Long id);

}
