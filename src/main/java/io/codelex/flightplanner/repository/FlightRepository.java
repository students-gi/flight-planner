package io.codelex.flightplanner.repository;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import io.codelex.flightplanner.domain.Flight;
import io.codelex.flightplanner.exceptions.DuplicateFlightException;

public class FlightRepository {
    private final Set<Flight> flights = new LinkedHashSet<>();

    public void addFlight(Flight flight) throws DuplicateFlightException {
        if (this.flights.contains(flight)) {
            throw new DuplicateFlightException("Flight with the following details already exists: " + flight);
        }
        flights.add(flight);
    }

    public Optional<Flight> findFlightById(Integer flightId) {
        return flights.stream()
                .filter(flight -> flight.getId().equals(flightId))
                .findFirst();
    }

    public boolean removeFlight(Flight flight) {
        return flights.remove(flight);
    }

    public boolean removeFlightById(Integer flightId) {
        Optional<Flight> optionalFlight = findFlightById(flightId);
        if (optionalFlight.isPresent()) {
            return removeFlight(optionalFlight.get());
        }
        return false;
    }

    public void clearFlights() {
        flights.clear();
    }

}
