package com.bubu.travelapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IsoCode {
    private boolean error;
    private String msg;
    private List<Infos> data;

    @Data
    @Accessors(chain = true)
    public static class Infos {
        private String name;

        @JsonProperty("Iso2")
        private String iso2;

        @JsonProperty("Iso3")
        private String iso3;
    }
}

