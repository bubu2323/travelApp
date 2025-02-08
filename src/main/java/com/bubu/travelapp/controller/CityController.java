package com.bubu.travelapp.controller;

import com.bubu.travelapp.model.City;
import com.bubu.travelapp.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    CityService cityService;

    @GetMapping("/cities-in/{stateId}")
    public List<City> getCitiesInState(@PathVariable String stateId) throws IOException, InterruptedException {
        return cityService.getCitiesInState(stateId);
    }
}
