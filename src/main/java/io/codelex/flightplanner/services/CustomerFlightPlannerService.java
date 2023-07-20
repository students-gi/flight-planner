package io.codelex.flightplanner.services;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import io.codelex.flightplanner.domain.Airport;
import io.codelex.flightplanner.domain.Flight;
import io.codelex.flightplanner.repository.FlightRepository;

@Service
public class CustomerFlightPlannerService {
    private final FlightRepository flightRepository;

    // Constructor
    public CustomerFlightPlannerService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    // Service methods
    public LinkedList<Airport> searchAirports(String searchParams) {
        // Get all (hopefully) unique airports in one place
        List<Airport> uniqueAirports = Stream.concat(
                this.flightRepository.getFlights().stream()
                        .map(Flight::getDepartingFrom),
                this.flightRepository.getFlights().stream()
                        .map(Flight::getArrivingTo))
                .distinct()
                .collect(Collectors.toList());
        LinkedList<Airport> applicableAirports = new LinkedList<Airport>();
        for (Airport airport : uniqueAirports) {
            // Easiest way to find the airport though a phrase
            // (though perhaps not computationally)
            // would be by utilizing its toString() method
            if (airport.toString().toUpperCase().contains(searchParams.toUpperCase())) {
                applicableAirports.add(airport);
            }
        }
        return applicableAirports;
    }


}
