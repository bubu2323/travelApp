package com.bubu.travelapp.services;

import com.bubu.travelapp.model.ApplicationProperties;
import com.bubu.travelapp.model.GeocodeResponse;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Service
@AllArgsConstructor
public class GeocodeServiceImpl implements GeocodeService {
    @Autowired
    ApplicationProperties applicationProperties;

    private final ObjectMapper objectMapper = new ObjectMapper();


    private final HttpClient httpClient = HttpClient.newHttpClient();
    @Override
    public GeocodeResponse.Root getResults(String searchValue, String locationType, int results) throws IOException, InterruptedException {

        String apiEndpoint = applicationProperties.getExternalApi().getGetResults();
        String apiKey = applicationProperties.getGeoApiKey();

        StringBuilder uriBuilder = new StringBuilder(apiEndpoint)
                .append("?text=").append(URLEncoder.encode(searchValue, StandardCharsets.UTF_8))
                .append("&limit=").append(results)
                .append("&format=json")
                .append("&apiKey=").append(apiKey);

        if (locationType != null && !locationType.isEmpty()) {
            uriBuilder.append("&type=").append(locationType);
        }

//        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uriBuilder.toString()))
                .GET()
                .build();
        HttpResponse<String> response = this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        GeocodeResponse.Root geocodeResponse = objectMapper.readValue(response.body(), GeocodeResponse.Root.class);

       return geocodeResponse;
    }
}

