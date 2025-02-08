package com.bubu.travelapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "development")
@Getter
@Setter
public class ApplicationProperties {
    public String apiKey;
    public String secrets;
    public ExternalApi externalApi;























}
