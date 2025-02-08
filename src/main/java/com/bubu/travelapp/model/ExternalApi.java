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
    String getCountry;
    String getRegionsAndProvince;
    String getCountries;
    String getCity;
    String getIsoCodes;
}
