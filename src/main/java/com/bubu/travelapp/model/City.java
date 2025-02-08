package com.bubu.travelapp.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class City {
    String id;
    String name;
}
