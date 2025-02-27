package com.bubu.travelapp.services;

import com.bubu.travelapp.model.GeocodeResponse;

import java.io.IOException;
import java.util.List;

public interface GeocodeService {
     GeocodeResponse.Root getResults(String searchValue, String locationType, int results) throws IOException, InterruptedException;
}
