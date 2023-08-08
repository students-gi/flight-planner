package io.codelex.flightplanner.repository;

import java.util.LinkedList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.codelex.flightplanner.domain.Flight;
import io.codelex.flightplanner.requests.ValidatedFlightSearchRequest;

public interface DatabaseTableFlights extends JpaRepository<Flight, Integer> {
    @Query("SELECT EXISTS ("
            + "SELECT 1 FROM Flights f WHERE "
                + "f.departingFrom.id = :#{#flight.getDepartingFrom().getId()} "
                + "AND f.arrivingTo.id = :#{#flight.getArrivingTo().getId()} "
                + "AND f.carrier = :#{#flight.getCarrier()} "
                + "AND f.datetimeOfDeparture = :#{#flight.getTimeOfDeparture()} "
                + "AND f.datetimeOfArrival = :#{#flight.getTimeOfArrival()}"
            + ") AS entry_exists")
    boolean existsExact(@Param("flight") Flight flight);

    @Query("SELECT f FROM Flights f WHERE "
            + "f.departingFrom.id IN :#{#flight.getDepartingFromList()} "
            + "AND f.arrivingTo.id IN :#{#flight.getArrivingToList()} "
            + "AND DATE(f.datetimeOfDeparture) = :#{#flight.getDateOfDeparture()}")
    LinkedList<Flight> searchFlight(@Param("flight") ValidatedFlightSearchRequest searchRequest);
}
