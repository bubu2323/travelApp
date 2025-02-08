package com.bubu.travelapp.services;

import com.bubu.travelapp.model.ApplicationProperties;
import com.bubu.travelapp.model.City;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    private final ApplicationProperties applicationProperties;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<City> getCitiesInState(String stateId) throws IOException, InterruptedException {
        String endpoint = this.replaceValueInString(
                applicationProperties.getExternalApi().getGetCity(),
                "\\{cityId}",
                stateId);

        String response = this.httpRequestBuilder(endpoint);
        List<City> cities = Arrays.asList(objectMapper.readValue(response, City[].class));
        return cities;
    }

    //TODO: refactor in an util class
    private String httpRequestBuilder(String endpoint) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .header("X-CSCAPI-KEY", applicationProperties.getApiKey())
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
//            System.out.println(response.body());
        return response.body();

    }
    private String replaceValueInString(String url, String placeholder, String newValue){
       return url.replaceAll(placeholder, newValue);
    }
}
