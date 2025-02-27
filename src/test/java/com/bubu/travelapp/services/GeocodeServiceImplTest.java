package com.bubu.travelapp.services;

import com.bubu.travelapp.model.ApplicationProperties;
import com.bubu.travelapp.model.ExternalApi;
import com.bubu.travelapp.model.GeocodeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.IOException;
import java.math.BigDecimal;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class GeocodeServiceImplTest {
    @Autowired
    private GeocodeServiceImpl geocodeService;

    @Mock
    ApplicationProperties applicationProperties;

    @Autowired
    private ObjectMapper mapper;
    @Mock
    HttpRequest httpRequest;

    @Mock
    HttpClient httpClient;

    @Mock
    HttpResponse<String> httpResponse;

    @Mock
    private ExternalApi externalApi;

    String endpoint = "http://apiAddress";
    String apiKey = "http://apiAddress";

    @BeforeEach
    public void setUp() {
        // Mock the ExternalApi bean and link it to ApplicationProperties
        given(applicationProperties.getExternalApi()).willReturn(externalApi);
        given(externalApi.getGetResults()).willReturn(endpoint);
        given(applicationProperties.getGeoApiKey()).willReturn(apiKey);
    }

    @Test
    void checkObjectMapper() {
        assertNotNull(mapper);
    }

    @Test
    void test_givenRequestWithParamsAndNoLocation_whenGetResults_thenRetrunGeocodeResponse() throws IOException, InterruptedException {
        String searchValue = "Rome";
        String locationType = null;

        GeocodeResponse.Result result = new GeocodeResponse.Result()
                .setCountry("Italy")
                .setCity("Rome")
                .setLon(new BigDecimal(1234567732))
                .setLat(new BigDecimal(334454334))
                .setFormatted("Rome, Italy")
                .setPlaceId("123454re5b55");

        GeocodeResponse.Query query = new GeocodeResponse.Query()
                .setText(searchValue);

        GeocodeResponse.Root geocodeRoot = new GeocodeResponse.Root()
                .setResults(List.of(result))
                .setQuery(query);

        String jsonResponse = mapper.writeValueAsString(geocodeRoot);

        given(httpClient.send(any(HttpRequest.class), eq(HttpResponse.BodyHandlers.ofString()))).willReturn(httpResponse);
        given(httpResponse.body()).willReturn(jsonResponse);

        GeocodeResponse.Root results = geocodeService.getResults(searchValue, locationType, 1);

        assertNotNull(results);
        assertFalse(results.getResults().isEmpty());

        GeocodeResponse.Result responseResult = results.getResults().get(0);
        assertEquals("Rome", responseResult.getCity());
        assertEquals("Italy", responseResult.getCountry());
//        assertEquals(12.496365, responseResult.getLon());
//        assertEquals(41.902783, responseResult.getLat());
        assertEquals("123454re5b55", responseResult.getPlaceId());


    }


}