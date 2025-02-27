package com.bubu.travelapp.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "external-api")
@Getter
@Setter
public class ExternalApi {
    private String getCountry;
    private String getRegionsAndProvince;
    private String getCountries;
    private String getCity;
    private String getIsoCodes;
    private String getResults;
}
