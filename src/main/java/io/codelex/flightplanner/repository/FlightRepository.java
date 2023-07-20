package io.codelex.flightplanner.repository;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import io.codelex.flightplanner.domain.Flight;
import io.codelex.flightplanner.exceptions.DuplicateFlightException;

@Repository
public class FlightRepository {
    private final Set<Flight> flights = new LinkedHashSet<>();

    public void addFlight(Flight flight) throws DuplicateFlightException {
        if (this.flights.contains(flight)) {
            throw new DuplicateFlightException("Flight with the following details already exists: " + flight);
        }
        flights.add(flight);
    }

    public List<Flight> getFlights() {
        return new LinkedList<>(this.flights);
    }

    public Optional<Flight> findFlightById(Integer flightId) {
        return this.flights.stream()
                .filter(flight -> flight.getId().equals(flightId))
                .findFirst();
    }

    public boolean removeFlight(Flight flight) {
        return this.flights.remove(flight);
    }

    public boolean removeFlightById(Integer flightId) {
        Optional<Flight> optionalFlight = this.findFlightById(flightId);
        if (optionalFlight.isPresent()) {
            return this.removeFlight(optionalFlight.get());
        }
        return false;
    }

    public void clearFlights() {
        this.flights.clear();
    }

}
