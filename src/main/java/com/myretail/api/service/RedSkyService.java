package com.myretail.api.service;

import com.myretail.api.exception.ProductNotFoundException;
import org.json.JSONException;

public interface RedSkyService {
    /**
     * Call the "internal" API to retrieve the name for a given product id
     * @param id product id
     * @return name of the product
     * @throws JSONException if an object does not have the required attributes to retrieve the name
     * @throws ProductNotFoundException if we cannot find any product information from the given id
     */
    String findProductNameById(int id) throws JSONException, ProductNotFoundException;

}
