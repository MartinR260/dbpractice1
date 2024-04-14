package com.example.dbpractice1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @PostMapping("/filter")
    public List<Airport> filterAirports(@RequestBody AirportFilter airportFilter, Pageable pageable) {
        return airportService.filterAirports(airportFilter, pageable);
    }
}