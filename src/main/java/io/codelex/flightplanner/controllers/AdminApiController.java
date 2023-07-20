package io.codelex.flightplanner.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.codelex.flightplanner.exceptions.DuplicateFlightException;
import io.codelex.flightplanner.exceptions.InvalidNewFlightRequest;
import io.codelex.flightplanner.requests.NewFlightRequest;
import io.codelex.flightplanner.responses.NewFlightResponse;
import io.codelex.flightplanner.services.AdminFlightPlannerService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin-api")
public class AdminApiController {
    private final AdminFlightPlannerService flightPlannerService;

    public AdminApiController(AdminFlightPlannerService flightPlannerService) {
        this.flightPlannerService = flightPlannerService;
    }

    @PutMapping("/flights")
    public ResponseEntity<NewFlightResponse> registerNewFlight(@Valid @RequestBody NewFlightRequest newFlightData) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.flightPlannerService.registerNewFlight(newFlightData));
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

    // Controller exception handlers
    @ExceptionHandler({ InvalidNewFlightRequest.class })
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String invalidFlightRequestExceptionHandler(InvalidNewFlightRequest e) {
        return e.getClass() + " happened: " + e.getMessage();
    }

    @ExceptionHandler({ DuplicateFlightException.class })
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public String duplicateFlightExceptionHandler(DuplicateFlightException e) {
        return e.getClass() + " happened: " + e.getMessage();
    }

}
