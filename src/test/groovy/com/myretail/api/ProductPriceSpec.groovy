package com.myretail.api


import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.myretail.api.model.ProductPriceDTO
import spock.lang.Specification

import static com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE

class ProductPriceSpec extends Specification {

    ObjectMapper objectMapper = new ObjectMapper().
            setPropertyNamingStrategy(SNAKE_CASE).
            registerModule(new Jdk8Module())

    void 'serialize to JSON'() {
        given: 'a ProductPriceDTO and an expected JSON value'
        ProductPriceDTO productPriceDTO = new ProductPriceDTO(1, 12, "USD")

        def expected = '{"value":12.0,"currency_code":"USD"}'

        when: 'convert the DTO object into a JSON formatted string'
        def actual = objectMapper.writeValueAsString(productPriceDTO)

        then:
        actual == expected
    }

}
