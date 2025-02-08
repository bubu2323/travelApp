package com.bubu.travelapp.services;


import com.bubu.travelapp.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final ApplicationProperties applicationProperties;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public CountryServiceImpl(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @Override
    public CountryDetails getCountry(String id) throws IOException, InterruptedException {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Country id cannot be null or empty.");
        }
        String countries = this.httpRequestBuilder(applicationProperties.getExternalApi().getGetCountry() + id, true);

        CountryDetails countryDetails = objectMapper.readValue(countries, CountryDetails.class);
        if (countryDetails == null) {
            throw new IllegalArgumentException("Country not found."); //TODO: verifica se esiste exception migliore
        }
        return countryDetails;
    }

    @Override
    public List<RegionsAndProvinces> getRegionsAndProvinces() throws IOException, InterruptedException {
        String response = this.httpRequestBuilder(applicationProperties.getExternalApi().getGetRegionsAndProvince(), true);
        List<RegionsAndProvinces> regionsAndProvinces = Arrays.asList(objectMapper.readValue(response, RegionsAndProvinces[].class));

        if (regionsAndProvinces.isEmpty()) {
            throw new IllegalArgumentException("RegionsAndProvince not found.");
        }
        return regionsAndProvinces;
    }

    @Override
    public List<Country> getAllCountries() throws IOException, InterruptedException {
        String response = this.httpRequestBuilder(applicationProperties.getExternalApi().getGetRegionsAndProvince(), true);
        List<Country> countries = Arrays.asList(objectMapper.readValue(response, Country[].class));

        if (countries.isEmpty()) {
            throw new IllegalArgumentException("Countries not found.");
        }
        return countries;
    }

    @Override
    public IsoCode getAllIsoCodes() throws IOException, InterruptedException {
        String response = this.httpRequestBuilder(applicationProperties.getExternalApi().getGetIsoCodes(), false);
        IsoCode isoCodes = objectMapper.readValue(response, IsoCode.class);
        return isoCodes;
    }

    private String httpRequestBuilder(String endpoint, Boolean isHeaderRequired) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder().uri(URI.create(endpoint));

        if (isHeaderRequired) {
            requestBuilder.header("X-CSCAPI-KEY", applicationProperties.getApiKey());
        }
        HttpRequest request = requestBuilder.build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
//            System.out.println(response.body());
        return response.body();
    }
}
