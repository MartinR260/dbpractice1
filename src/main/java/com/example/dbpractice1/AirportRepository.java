package com.example.dbpractice1;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    @Query("SELECT a FROM Airport a WHERE (:#{#filter.countryIso2Codes} IS EMPTY OR a.city.country.iso2CountryCode IN :#{#filter.countryIso2Codes}) " +
            "AND (:#{#filter.cityIds} IS EMPTY OR a.city.id IN :#{#filter.cityIds}) " +
            "AND (:#{#filter.airportIcaoCodes} IS EMPTY OR a.icaoCode IN :#{#filter.airportIcaoCodes}) " +
            "AND (:#{#filter.airportNames} IS EMPTY OR a.name IN :#{#filter.airportNames})")
    List<Airport> findFilteredAirports(AirportFilter filter, Pageable pageable);
}