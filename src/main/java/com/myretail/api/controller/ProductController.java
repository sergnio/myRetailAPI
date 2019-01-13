package com.myretail.api.controller;

import com.myretail.api.exception.ProductNotFoundException;
import com.myretail.api.model.ProductDTO;
import com.myretail.api.model.ProductPriceDTO;
import com.myretail.api.service.ProductServiceImpl;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("products/{id}")
    @ResponseStatus(HttpStatus.OK)
    ProductDTO getProduct(@PathVariable int id) {
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
                    HttpStatus.NOT_FOUND, "ProductDTO id: " + id + " not found on API server", e);
        }
    }

    @PutMapping("/products/{id}")
    // No need to return a body. See https://tools.ietf.org/html/rfc2616#section-10.2.5
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateProductPrice(@PathVariable int id, @RequestBody ProductDTO productDTO) {
        // Grab the id from the path variable. Sending an ID in JSON body is redundant.
        // Don't have to return anything other than the status
        ProductPriceDTO productPriceDTO = productDTO.getProductPriceDTO();
        productPriceDTO.setId(id);
        try {
            productService.updateById(productPriceDTO);
        } catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

}
