package com.myretail.api.service;

import com.myretail.api.exception.ProductNotFoundException;
import com.myretail.api.model.ProductDTO;
import com.myretail.api.model.ProductPriceDTO;
import com.myretail.api.repository.ProductRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    private final RestTemplate restTemplate;

    @Value("${myretail.baseUrl}")
    private String baseUrl;
    @Value("${myretail.params}")
    private String params;

    public ProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public ProductDTO findById(int id) throws ProductNotFoundException {
        // Also make microservice calls here probably
        ProductPriceDTO productPriceDTO = productRepository.findById(id);
        String name = findProductNameById(id);

        // TODO - check how these microservices are actually done?? JP
        return new ProductDTO(id, name, productPriceDTO);
    }

    @Override
    public List<ProductPriceDTO> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductPriceDTO updateById(ProductPriceDTO productPriceDTO) {
        if (productRepository.findById(productPriceDTO.getId()) != null) {
            // return some message to say it was updated ?
        } else {
            // return some message to say it was a new object created ?
        }
        return productRepository.save(productPriceDTO);
    }

    // takes a productprice
    // finds the name from the api
    // creates a new product based off this information
    // set id from the id param
    private String findProductNameById(int id) throws JSONException, ProductNotFoundException {
         // Break out a BASE URl (up to tcin/)
         // have the id param go before the rest of the
         // excludes portion
         // 13860428
        String RESTUrl = baseUrl + String.valueOf(id) + params;

        // TODO - create test case for when object doesn't exist: id=99999999
        // Response is returned as a string
        try {
            String response = this.restTemplate.getForObject(RESTUrl, String.class);
            // Convert to JSON to easier manipulate
            JSONObject json = new JSONObject(response);

            return json
                    .getJSONObject("product")
                    .getJSONObject("item")
                    .getJSONObject("product_description")
                    .get("title")
                    .toString();
        } catch (RestClientException e) {
            throw new ProductNotFoundException("No product id " + id + " found on GET request for URL: " + RESTUrl);
        }

    }

}


