package io.codelex.flightplanner.services;

import org.springframework.stereotype.Service;

import io.codelex.flightplanner.repository.FlightRepository;

@Service
public class TestFlightPlannerService {
    private final FlightRepository flightRepository;

    // Constructor
    public TestFlightPlannerService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    // Service methods
    public void clearFlightRepository() {
        this.flightRepository.clearFlights();
    }

}
