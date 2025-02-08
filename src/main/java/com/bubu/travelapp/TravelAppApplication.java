package com.bubu.travelapp;

import com.bubu.travelapp.model.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class TravelAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelAppApplication.class, args);
    }

}
