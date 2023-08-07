package io.codelex.flightplanner.repository;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import io.codelex.flightplanner.domain.Airport;
import io.codelex.flightplanner.domain.Flight;
import io.codelex.flightplanner.exceptions.DuplicateFlightException;
import io.codelex.flightplanner.requests.ValidatedFlightSearchRequest;

@Repository
public class FlightRepository {
    private final Set<Flight> flights = new LinkedHashSet<>();

    public synchronized void addFlight(Flight flight) throws DuplicateFlightException {
        if (this.flights.contains(flight)) {
            throw new DuplicateFlightException("Flight with the following details already exists: " + flight);
        }
        flights.add(flight);
    }

    public List<Flight> getFlights() {
        return new LinkedList<>(this.flights);
    }

    public synchronized boolean removeFlight(Flight flight) {
        return this.flights.remove(flight);
    }

    public synchronized boolean removeFlightById(Integer flightId) {
        Optional<Flight> optionalFlight = this.findFlightById(flightId);
        if (optionalFlight.isPresent()) {
            return this.removeFlight(optionalFlight.get());
        }
        return false;
    }

    public synchronized void clearFlights() {
        this.flights.clear();
    }

    // Flight property manipulations
    public List<Airport> getAirports() {
        Set<Airport> uniqueAirports = new LinkedHashSet<>();

        // Get all (hopefully) unique airports in one place
        for (Flight flight : flights) {
            uniqueAirports.add(flight.getDepartingFrom());
            uniqueAirports.add(flight.getArrivingTo());
        }

        return new LinkedList<>(uniqueAirports);
    }

    public List<Airport> findAirports(String searchParams) {
        List<Airport> knownAirports = this.getAirports();
        List<Airport> applicableAirports = new LinkedList<Airport>();

        String searchableParams = searchParams.toUpperCase();
        for (Airport airport : knownAirports) {
            // Easiest way to find the airport though a phrase
            // (though perhaps not computationally)
            // would be by utilizing its toString() method
            if (airport.toString().toUpperCase().contains(searchableParams)) {
                applicableAirports.add(airport);
            }
        }
        return applicableAirports;
    }

    public List<Flight> findFlights(ValidatedFlightSearchRequest searchRequest) {
        LinkedList<Flight> matchingFlights = new LinkedList<>();

        for (Flight flight : flights) {
            if ((!searchRequest.getDepartingFromList().contains(flight.getDepartingFrom()))
                || (!searchRequest.getArrivingToList().contains(flight.getArrivingTo()))
                || (!searchRequest.getDateOfDeparture().equals(flight.getTimeOfDeparture().toLocalDate()))) {
                continue;
            }

            matchingFlights.add(flight);
        }

        return matchingFlights;
    }

    public Optional<Flight> findFlightById(Integer flightId) {
        return this.flights.stream()
                .filter(flight -> flight.getId().equals(flightId))
                .findFirst();
    }

}
