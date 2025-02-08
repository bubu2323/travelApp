package com.bubu.travelapp.test;

import com.bubu.travelapp.model.ApplicationProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@EnableConfigurationProperties(ApplicationProperties.class)
class ApplicationPropertiesTests {
    @Autowired
    ApplicationProperties applicationProperties;

    @Test
    void test_givenProperties_whenGetProperties_thenMatchResult() {
    assertEquals(applicationProperties.getExternalApi().getGetCountry(), "https://api.countrystatecity.in/v1/countries/IN");
    }

}
