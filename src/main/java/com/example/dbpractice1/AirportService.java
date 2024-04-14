package com.example.dbpractice1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public List<Airport> filterAirports(AirportFilter airportFilter, Pageable pageable) {
        if (airportFilter == null) {
            return airportRepository.findAll(pageable).getContent();
        } else {
            return airportRepository.findFilteredAirports(airportFilter, pageable);
        }
    }
}
