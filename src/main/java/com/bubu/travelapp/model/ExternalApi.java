package com.bubu.travelapp.model;

import lombok.Getter;
import lombok.Setter;
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
}
