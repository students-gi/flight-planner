package io.codelex.flightplanner.controllers;

import java.util.LinkedList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.codelex.flightplanner.domain.Airport;
import io.codelex.flightplanner.requests.FlightSearchRequest;
import io.codelex.flightplanner.services.CustomerFlightPlannerService;

@RestController
@RequestMapping("/api")
public class CustomerApiController {
    private final CustomerFlightPlannerService flightPlannerService;

    public CustomerApiController(CustomerFlightPlannerService flightPlannerService) {
        this.flightPlannerService = flightPlannerService;
    }

    @GetMapping("/airports")
    public ResponseEntity<LinkedList<Airport>> searchAirports(@RequestParam String search) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.flightPlannerService.searchAirports(search.trim()));
    }

    @PostMapping("/flights/search")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void searchFlights(@RequestBody FlightSearchRequest flightSearchRequest) {
        // Insert flight search functionality
    }

    @GetMapping("/flights/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void getFlightById(@PathVariable String id) {
        // Insert flight data retrieval functionality
    }

}
