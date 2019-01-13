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

}
