package com.bubu.travelapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
@Data
@Accessors(chain = true)
public class Country {
    @Id
    Integer id;
    String name;
    String iso2;
    String iso3;
    @JsonProperty(value = "phonecode")
    String phoneCode;
    String capital;
    String currency;
    @JsonProperty(value = "native")
    String nativ;
    String emoji;
}
