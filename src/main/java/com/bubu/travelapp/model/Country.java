package com.bubu.travelapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)

public class Country {
    private int id;
    private String name;
    private String country_id;
    private String country_code;
    private String iso2;
    private String type;
    private String latitude;
    private String longitude;
}

