package io.codelex.flightplanner.repository;

import java.util.LinkedList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.codelex.flightplanner.domain.Airport;

public interface DatabaseTableAirports extends JpaRepository<Airport, String> {
    @Query("SELECT EXISTS ("
            + "SELECT 1 FROM Airport WHERE "
                + "id = :#{#airport.getId()} "
                + "AND country = :#{#airport.getCountry()} "
                + "AND city = :#{#airport.getCity()}"
            + ") AS entry_exists")
    boolean existsExact(@Param("airport") Airport airport);

    @Query("SELECT a FROM Airport a WHERE "
            + "a.id ILIKE %:substring% "
            + "OR a.country ILIKE %:substring% "
            + "OR a.city ILIKE %:substring%")
    LinkedList<Airport> searchAirport(@Param("substring") String searchString);
}