package io.codelex.flightplanner.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.codelex.flightplanner.requests.NewFlightRequest;
import io.codelex.flightplanner.services.AdminFlightPlannerService;

@RestController
@RequestMapping("/admin-api")
public class AdminApiController {
    private final AdminFlightPlannerService flightPlannerService;

    public AdminApiController(AdminFlightPlannerService flightPlannerService) {
        this.flightPlannerService = flightPlannerService;
    }

    @PutMapping("/flights")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void registerNewFlight(@RequestBody NewFlightRequest newFlightData) {
        // Insert flight registration functionality
    }

    @GetMapping("/flights/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void getFlightById(@PathVariable String id) {
        // Insert flight data retrieval functionality
    }

    @DeleteMapping("/flights/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteFlightById(@PathVariable String id) {
        // Insert flight deletion functionality
    }

}
