package com.myretail.api.service;

import com.myretail.api.exception.ProductNotFoundException;
import com.myretail.api.model.ProductDTO;
import com.myretail.api.model.ProductPriceDTO;
import org.json.JSONException;

import java.util.List;

public interface ProductService {
    /**
     * Grab Product name from our "internal" API and grab the product price from the database.
     * Create a ProductDTO from these combined sources.
     * @param id product id
     * @return product
     */
    ProductDTO findById(int id) throws ProductNotFoundException;

    /**
     * Updates a product price in the database.
     * This method is not responsible for creation of new productPrices.
     * @param productPriceDTO pass the entire object to update a matching productPrice
     * @throws ProductNotFoundException if the product id doesn't match any productPrice id in the database.
     */
    void updateById(ProductPriceDTO productPriceDTO) throws ProductNotFoundException;

}
