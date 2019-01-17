package com.myretail.api.controller;

import com.myretail.api.exception.ProductNotFoundException;
import com.myretail.api.model.ProductDTO;
import com.myretail.api.model.ProductPriceDTO;
import com.myretail.api.service.ProductPriceServiceImpl;
import com.myretail.api.service.ProductServiceImpl;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * Controller responsible for all REST calls regarding products.
 */
@RestController
@RequestMapping("/v1")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private ProductPriceServiceImpl productPriceService;

    /**
     * Should return a product containing its name and pricing information.
     * This REST method can fail if there isn't a product with a matching id in the database, external API,
     * or if there is not enough product information.
     * @param id product id
     * @return complete ProductDTO
     */
    @GetMapping("products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProduct(@PathVariable int id) {
        try {
            ProductDTO productDTO = productService.findById(id);
            if (productDTO == null) {
                throw new ProductNotFoundException(id);
            }
            return productDTO;
        } catch (ProductNotFoundException | JSONException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
            // Add generic message for general exceptions
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Something has gone wrong. Please check logs.", e);
        }
    }

    /**
     * Updates a product price, given a productPrice object.
     * @param id product id
     * @param productDTO no to include id in JSON body, we grab this from the URI
     */
    @PutMapping("products/{id}")
    // No need to return a body. See https://tools.ietf.org/html/rfc2616#section-10.2.5
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProductPrice(@PathVariable int id, @RequestBody ProductDTO productDTO) {
        // Grab the id from the path variable. Sending an ID in JSON body is redundant.
        // Don't have to return anything other than the status
        ProductPriceDTO productPriceDTO = productDTO.getProductPriceDTO();
        productPriceDTO.setId(id);
        try {
            productPriceService.updateById(productPriceDTO);
        } catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Something has gone wrong. Please check logs.", e);
        }
    }

    /**
     * An extremely simple API to check if server is running.
     * @return basic string.
     */
    @GetMapping("health")
    @ResponseStatus(HttpStatus.OK)
    public String health() {
        return "Server is running";
    }
}
