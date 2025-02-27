package com.bubu.travelapp.services;

import com.bubu.travelapp.model.*;

import java.io.IOException;
import java.util.List;

public interface CountryService {
     CountryDetails getCountry(String id) throws IOException, InterruptedException;

     List<RegionsAndProvinces> getRegionsAndProvinces() throws IOException, InterruptedException;

     List<Country> getAllCountries() throws IOException, InterruptedException;

     IsoCode getAllIsoCodes() throws IOException, InterruptedException;
}
