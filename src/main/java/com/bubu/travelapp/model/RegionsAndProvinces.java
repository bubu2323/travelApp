package com.bubu.travelapp.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RegionsAndProvinces {
    String id;
    String name;
    String country_id;
    String country_code;
    String iso2;
    String type;
    String latitude;
    String longitude;
}
