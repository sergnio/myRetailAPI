package com.myretail.api.service;

import com.myretail.api.model.Product;
import com.myretail.api.model.ProductPrice;
import com.myretail.api.repository.ProductRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    private final RestTemplate restTemplate;

    public ProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    @Override
    // TODO - rename to match its context
    public Product findById(int id) {
        // Also make microservice calls here probably
        ProductPrice productPrice = productRepository.findById(id);
        String name = findProductNameById(id);

        // TODO - check how these microservices are actually done?? JP
        return new Product(id, name, productPrice);
    }

    @Override
    public List<ProductPrice> findAll() {
        return productRepository.findAll();
    }

    // takes a productprice
    // finds the name from the api
    // creates a new product based off this information
    // set id from the id param
     String findProductNameById(int id) {
         // Break out a BASE URl (up to tcin/)
         // have the id param go before the rest of the
         // excludes portion
         // 13860428
          final String baseUrl = "https://redsky.target.com/v2/pdp/tcin/";
          final String params = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics,deep_red_labels,available_to_promise_network";
         String RESTUrl = baseUrl + String.valueOf(id) + params;


        // TODO - create test case for when object doesn't exist: id=99999999
        JSONObject response = new JSONObject(this.restTemplate.getForObject(RESTUrl, String.class));

        return response.
                getJSONObject("product").
                getJSONObject("item").
                getJSONObject("product_description").
                get("title")
                .toString();

    }

}


