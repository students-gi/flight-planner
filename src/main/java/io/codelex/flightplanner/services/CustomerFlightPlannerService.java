package io.codelex.flightplanner.services;

import org.springframework.stereotype.Service;

import io.codelex.flightplanner.repository.FlightRepository;

@Service
public class CustomerFlightPlannerService {
    private final FlightRepository flightRepository;

    // Constructor
    public CustomerFlightPlannerService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    // Service methods

}
