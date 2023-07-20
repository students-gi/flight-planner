package io.codelex.flightplanner.services;

import org.springframework.stereotype.Service;

import io.codelex.flightplanner.repository.FlightRepository;

@Service
public class AdminFlightPlannerService {
    private final FlightRepository flightRepository;

    // Constructor
    public AdminFlightPlannerService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    // Service methods

}
