package com.bubu.travelapp.controller;

import com.bubu.travelapp.model.GeocodeResponse;
import com.bubu.travelapp.services.GeocodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/search")
public class GeocodeController {
    @Autowired
    GeocodeService geocodeService;

    @GetMapping("/details")
    //recupera le info della ricerca effettuata
    public GeocodeResponse.Root getResult(@RequestParam(name = "text") String searchValue,
                                          @RequestParam(name = "type", required = false) String locationType,
                                          @RequestParam(name = "limit", defaultValue = "1") int results) throws IOException, InterruptedException {
        return geocodeService.getResults(searchValue, locationType, results);
    }

}
