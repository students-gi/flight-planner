package io.codelex.flightplanner.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.codelex.flightplanner.domain.Airport;
import io.codelex.flightplanner.exceptions.InvalidFlightSearchRequest;
import io.codelex.flightplanner.exceptions.UnregisteredFlightIdException;
import io.codelex.flightplanner.requests.FlightSearchRequest;
import io.codelex.flightplanner.responses.FlightResponse;
import io.codelex.flightplanner.responses.FlightSearchResponse;
import io.codelex.flightplanner.services.CustomerFlightPlannerService;

@RestController
@RequestMapping("/api")
public class CustomerApiController {
    private final CustomerFlightPlannerService flightPlannerService;

    public CustomerApiController(CustomerFlightPlannerService flightPlannerService) {
        this.flightPlannerService = flightPlannerService;
    }

    @GetMapping("/airports")
    public ResponseEntity<List<Airport>> searchAirports(@RequestParam String search) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.flightPlannerService.searchAirports(search.trim()));
    }

    @PostMapping("/flights/search")
    public ResponseEntity<FlightSearchResponse> searchFlights(@RequestBody FlightSearchRequest flightSearchRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.flightPlannerService.searchFlights(flightSearchRequest));
    }

    @GetMapping("/flights/{flightId}")
    public ResponseEntity<FlightResponse> getFlightById(@PathVariable Integer flightId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.flightPlannerService.searchFlightById(flightId));
    }

    // Controller exception handlers
    @ExceptionHandler({ InvalidFlightSearchRequest.class })
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String invalidFlightSearchRequestExceptionHandler(InvalidFlightSearchRequest e) {
        return e.getClass() + " happened: " + e.getMessage();
    }

    @ExceptionHandler({ UnregisteredFlightIdException.class })
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public String UnregisteredFlightIdExceptionHandler(UnregisteredFlightIdException e) {
        return e.getClass() + " happened: " + e.getMessage();
    }

}
