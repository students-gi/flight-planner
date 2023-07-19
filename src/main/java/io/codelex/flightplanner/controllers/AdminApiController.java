package io.codelex.flightplanner.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin-api")
public class AdminApiController {

    @PutMapping("/flights")
    public void registerNewFlight(@RequestBody NewFlightData newFlightData) {
        // Insert flight registration functionality
    }

    @GetMapping("/flights/{id}")
    public void getFlightById(@PathVariable String id) {
        // Insert flight data retrieval functionality
    }

    @DeleteMapping("/flights/{id}")
    public void deleteFlightById(@PathVariable String id) {
        // Insert flight deletion functionality
    }

}
