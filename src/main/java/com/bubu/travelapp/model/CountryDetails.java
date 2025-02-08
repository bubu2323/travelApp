package com.bubu.travelapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CountryDetails {
    private int id;
    private String name;
    private String iso3;
    @JsonProperty("numeric_code")
    private String numericCode;
    private String iso2;
    private String phonecode;
    private String capital;
    private String currency;
    @JsonProperty("currency_name")
    private String currencyName;
    @JsonProperty("currency_symbol")
    private String currencySymbol;
    private String tld;
    @JsonProperty("native")
    private String nativ;
    private String region;
    @JsonProperty("region_id")
    private int regionId;
    private String subregion;
    @JsonProperty("subregion_id")
    private int subregionId;
    private String nationality;
    private String timezones;
    private String translations;
    private String latitude;
    private String longitude;
    private String emoji;
    private String emojiU;
}

