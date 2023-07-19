package io.codelex.flightplanner.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerApiController {

    @GetMapping("/airports")
    public void searchAirports(@RequestParam String searchParams) {
        // Insert airport search functionality
    }

    @PostMapping("/flights/search")
    public void searchFlights(@RequestBody FlightSearchRequest flightSearchRequest) {
        // Insert flight search functionality
    }

    @GetMapping("/flights/{id}")
    public void getFlightById(@PathVariable String id) {
        // Insert flight data retrieval functionality
    }

}
