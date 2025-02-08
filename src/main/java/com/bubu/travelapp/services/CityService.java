package com.bubu.travelapp.services;

import com.bubu.travelapp.model.City;

import java.io.IOException;
import java.util.List;

public interface CityService {
    List<City> getCitiesInState(String stateId) throws IOException, InterruptedException;
}
