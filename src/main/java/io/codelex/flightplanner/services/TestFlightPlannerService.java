package io.codelex.flightplanner.services;

import org.springframework.stereotype.Service;

import io.codelex.flightplanner.repository.FlightRepositoryInterface;

@Service
public class TestFlightPlannerService {
    private final FlightRepositoryInterface flightRepository;

    // Constructor
    public TestFlightPlannerService(FlightRepositoryInterface flightRepository) {
        this.flightRepository = flightRepository;
    }

    // Service methods
    public void clearFlightRepository() {
        this.flightRepository.clearFlights();
    }

}
