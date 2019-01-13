package com.myretail.api.service;

import com.myretail.api.exception.ProductNotFoundException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class RedSkyServiceImpl implements RedSkyService {

    private final RestTemplate restTemplate;

    @Value("${myretail.baseUrl}")
    private String baseUrl;
    @Value("${myretail.params}")
    private String params;

    public RedSkyServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
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
