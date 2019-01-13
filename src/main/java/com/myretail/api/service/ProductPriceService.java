package com.myretail.api.service;

import com.myretail.api.exception.ProductNotFoundException;
import com.myretail.api.model.ProductPriceDTO;

public interface ProductPriceService {
    /**
     * Updates a product price in the database.
     * This method is not responsible for creation of new productPrices.
     * @param productPriceDTO pass the entire object to update a matching productPrice
     * @throws ProductNotFoundException if the product id doesn't match any productPrice id in the database.
     */
    void updateById(ProductPriceDTO productPriceDTO) throws ProductNotFoundException;

}
