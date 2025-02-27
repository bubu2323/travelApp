package com.bubu.travelapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeResponse {
    @Data
    @Accessors(chain = true)
    public static class Result {
        private Datasource datasource;
        private String country;
        private String country_code;
        private String state;
        private String county;
        private String city;
        //TODO: trovare il modo di renderli precisi
        private BigDecimal lon;
        private BigDecimal lat;
        private String state_code;
        private String result_type;
        private String formatted;
        private String address_line1;
        private String address_line2;
        private String category;
        private Timezone timezone;
        private String plus_code;
        private String plus_code_short;
        private String postcode;
        private Rank rank;
        @JsonProperty("place_id")
        private String placeId;
        private Bbox bbox;
    }

    @Data
    @Accessors(chain = true)
    public static class Bbox {
        private double lon1;
        private double lat1;
        private double lon2;
        private double lat2;
    }

    @Data
    @Accessors(chain = true)
    @JsonIgnoreType
    public static class Datasource {
        private String sourcename;
        private String attribution;
        private String license;
        private String url;
    }

    @Data
    @Accessors(chain = true)
    public static class Parsed {
        private String city;
        private String expected_type;
    }

    @Data
    @Accessors(chain = true)
    public static class Query {
        private String text;
        private Parsed parsed;
    }

    @Data
    @Accessors(chain = true)
    public static class Rank {
        private double importance;
        private double popularity;
        private int confidence;
        private int confidence_city_level;
        private String match_type;
    }

    @Data
    @Accessors(chain = true)
    public static class Timezone {
        private String name;
        private String offset_STD;
        private int offset_STD_seconds;
        private String offset_DST;
        private int offset_DST_seconds;
        private String abbreviation_STD;
        private String abbreviation_DST;
    }


    @Data
    @Accessors(chain = true)
    public static class Root {
        private List<Result> results;
        private Query query;
    }
}
