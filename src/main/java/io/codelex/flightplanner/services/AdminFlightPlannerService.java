package io.codelex.flightplanner.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import io.codelex.flightplanner.domain.Airport;
import io.codelex.flightplanner.domain.Flight;
import io.codelex.flightplanner.exceptions.DuplicateFlightException;
import io.codelex.flightplanner.exceptions.InvalidNewFlightRequest;
import io.codelex.flightplanner.repository.FlightRepository;
import io.codelex.flightplanner.requests.NewFlightRequest;
import io.codelex.flightplanner.responses.NewFlightResponse;
import io.codelex.flightplanner.utils.LocalDateTimeFormatter;

@Service
public class AdminFlightPlannerService {
    private final FlightRepository flightRepository;

    // Constructor
    public AdminFlightPlannerService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    /******
     * Provides funtionality for adding a new flight to the repository
     *
     * @throws InvalidNewFlightRequest when flight data validation has failed
     * @throws DuplicateFlightException when an identical flight has been identified in the existing repository
    **/
    public NewFlightResponse registerNewFlight(NewFlightRequest newFlightRequest)
            throws InvalidNewFlightRequest, DuplicateFlightException {
        Flight newFlight = validateFlight(newFlightRequest);
        flightRepository.addFlight(newFlight);
        NewFlightResponse newFlightResponse = responseFlight(newFlight);
        return newFlightResponse;
    }

    /******
     * Validates a flight request values
     *
     * @throws InvalidNewFlightRequest
    **/
    private static Flight validateFlight(NewFlightRequest flightToValidate)
            throws InvalidNewFlightRequest {

        // Verifying the airports
        Airport departingFrom = flightToValidate.getDepartingFrom();
        Airport arrivingTo = flightToValidate.getArrivingTo();
        if (departingFrom == null || arrivingTo == null) {
            throw new InvalidNewFlightRequest("Airports cannot be null");
        }
        if (departingFrom.equals(arrivingTo)) {
            throw new InvalidNewFlightRequest("Departure and arrival airports cannot be identical");
        }

        // Verifying the carrier
        String carrier = flightToValidate.getCarrier();
        if (carrier == null || carrier.isBlank()) {
            throw new InvalidNewFlightRequest("Flight carrier cannot be empty or null");
        }

        // Verifying the datetimes
        LocalDateTime timeOfDeparture = LocalDateTimeFormatter.stringToDateTime(flightToValidate.getTimeOfDeparture());
        LocalDateTime timeOfArrival = LocalDateTimeFormatter.stringToDateTime(flightToValidate.getTimeOfArrival());
        if (timeOfDeparture == null || timeOfArrival == null) {
            throw new InvalidNewFlightRequest("Flight times cannot be null");
        }
        if (timeOfDeparture.isAfter(timeOfArrival)) {
            throw new InvalidNewFlightRequest("Time of departure cannot be after time of arrival");
        }
        if (timeOfDeparture.isEqual(timeOfArrival)) {
            throw new InvalidNewFlightRequest("Time of departure cannot be identical to time of arrival");
        }

        // Everything is nice; return a validated object
        return new Flight(
                departingFrom,
                arrivingTo,
                carrier,
                timeOfDeparture,
                timeOfArrival);
    }

    /******
     *  Converts the flight domain object into a response
    **/
    private static NewFlightResponse responseFlight(Flight completedFlight) {
        return new NewFlightResponse(
            completedFlight.getId(),
            completedFlight.getDepartingFrom(),
            completedFlight.getArrivingTo(),
            completedFlight.getCarrier(),
            completedFlight.getTimeOfDeparture(),
            completedFlight.getTimeOfArrival()
        );
    }

}
