package com.bubu.travelapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RegionsAndProvinces {
    private  String id;
    private String name;
    @JsonProperty(value = "country_id")
    private  String countryId;
    @JsonProperty(value = "country_code")
    private  String countryCode;
    private  String iso2;
    private  String type;
    private  String latitude;
    private  String longitude;
}
