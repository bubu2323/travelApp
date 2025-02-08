package com.bubu.travelapp.controller;

import com.bubu.travelapp.model.Country;
import com.bubu.travelapp.model.CountryDetails;
import com.bubu.travelapp.model.IsoCode;
import com.bubu.travelapp.model.RegionsAndProvinces;
import com.bubu.travelapp.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RequestMapping("/country")
@RestController
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping("/{id}")
    //recupera le info di una nazione in base al codice passato
    public CountryDetails getCountry(@PathVariable String id) throws IOException, InterruptedException {
        return countryService.getCountry(id);
    }

    @GetMapping("/regions-and-province")
    //recupera le info di tutte le province e/o nazioni
    public List<RegionsAndProvinces> getRegionsAndProvince() throws IOException, InterruptedException {
        return countryService.getRegionsAndProvinces();

    }

    @GetMapping("/countries-list")
    //recupera tutti gli stati/nazioni
    public List<Country> getALlCountries() throws IOException, InterruptedException {
        return countryService.getAllCountries();

    }
    @GetMapping("/isoCodes")
    //recupera tutti gli isoCode (iso2 e iso3) di tutti gli stati/nazione
    public IsoCode getIsoCodes() throws IOException, InterruptedException {
        return countryService.getAllIsoCodes();

    }
}
