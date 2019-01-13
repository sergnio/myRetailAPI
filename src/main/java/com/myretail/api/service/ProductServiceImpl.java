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
        ProductPriceDTO productPriceDTO = productRepository.findById(id);
        String name = findProductNameById(id);

        // TODO - check how these microservices are actually done?? JP
        return new ProductDTO(id, name, productPriceDTO);
    }

    @Override
    public void updateById(ProductPriceDTO productPriceDTO) throws ProductNotFoundException {
        if (productRepository.findById(productPriceDTO.getId()) != null) {
            productRepository.save(productPriceDTO);
        } else {
            // Throw an exception if the product id isn't found. Create a POST to create a new product.
            throw new ProductNotFoundException(productPriceDTO.getId());
        }
    }

    @Override
    public String findProductNameById(int id) throws JSONException, ProductNotFoundException {
        String RESTUrl = baseUrl + String.valueOf(id) + params;

        // TODO - create test case for when object doesn't exist: id=99999999
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


