package com.myretail.api.controller;

import com.myretail.api.exception.ProductNotFoundException;
import com.myretail.api.model.ProductDTO;
import com.myretail.api.model.ProductPriceDTO;
import com.myretail.api.service.ProductServiceImpl;
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
        } catch (ProductNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
            // Add generic message for general exceptions
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ProductDTO id: " + id + " not found on API server", e);
        }
    }

    @PutMapping("/products/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void updateProductPrice(@PathVariable int id, @RequestBody ProductDTO productDTO) {
        // Grab the id from the path variable. Sending an ID in JSON body is redundant.
        ProductPriceDTO productPriceDTO = productDTO.getProductPriceDTO();
        productPriceDTO.setId(id);
        productService.updateById(productPriceDTO);
    }


    @GetMapping("products/")
    @ResponseStatus(HttpStatus.OK)
    List<ProductPriceDTO> getAllProducts() { return productService.findAll(); }
}
