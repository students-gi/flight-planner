package io.codelex.flightplanner.services;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.codelex.flightplanner.domain.Airport;
import io.codelex.flightplanner.domain.Flight;
import io.codelex.flightplanner.exceptions.InvalidFlightSearchRequest;
import io.codelex.flightplanner.exceptions.UnregisteredFlightIdException;
import io.codelex.flightplanner.repository.FlightRepositoryInterface;
import io.codelex.flightplanner.requests.FlightSearchRequest;
import io.codelex.flightplanner.requests.ValidatedFlightSearchRequest;
import io.codelex.flightplanner.responses.FlightResponse;
import io.codelex.flightplanner.responses.FlightSearchResponse;
import io.codelex.flightplanner.utils.LocalDateTimeFormatter;

@Service
public class CustomerFlightPlannerService {
    private final FlightRepositoryInterface flightRepository;

    // Constructor
    public CustomerFlightPlannerService(FlightRepositoryInterface flightRepository) {
        this.flightRepository = flightRepository;
    }

    // Service methods
    public List<Airport> searchAirports(String searchParams) {
        return flightRepository.findAirports(searchParams);
    }

    public FlightSearchResponse searchFlights(FlightSearchRequest searchRequest)
            throws InvalidFlightSearchRequest {
        ValidatedFlightSearchRequest search = validateFlightSearch(searchRequest);
        List<Flight> filteredFlights = this.flightRepository.findFlights(search);

        // Probably needs some kind of a page counter; no clue how it's supposed to be calcuated though
        // Meaning, the page size limits have not been given in the task definition
        Integer pageCount = (filteredFlights.isEmpty()) ? 0 : 1;
        return new FlightSearchResponse(pageCount, new LinkedList<Flight>(filteredFlights));
    }

    private ValidatedFlightSearchRequest validateFlightSearch(FlightSearchRequest requestToValidate)
            throws InvalidFlightSearchRequest {
        // Validating airports
        if (requestToValidate.getDepartingFrom() == null || requestToValidate.getArrivingTo() == null) {
            throw new InvalidFlightSearchRequest("Airports cannot be null");
        }
        if (requestToValidate.getDepartingFrom().equals(requestToValidate.getArrivingTo())) {
            throw new InvalidFlightSearchRequest("Departure and arrival airports cannot be identical");
        }
        List<Airport> departingAirportList = this.searchAirports(requestToValidate.getDepartingFrom());
        List<Airport> arrivalAirportList = this.searchAirports(requestToValidate.getArrivingTo());

        // Validating departure date
        if (requestToValidate.getDateOfDeparture() == null) {
            throw new InvalidFlightSearchRequest("Flight date cannot be null");
        }
        LocalDate flightDepartureDate;
        try {
            flightDepartureDate = LocalDateTimeFormatter.stringToDate(requestToValidate.getDateOfDeparture());
        } catch (DateTimeParseException e) {
            throw new InvalidFlightSearchRequest("Flight date is not valid: " + e.getMessage());
        }

        // Seems like validation worked; time to return the complete request back
        return new ValidatedFlightSearchRequest(departingAirportList, arrivalAirportList, flightDepartureDate);
    }

    public FlightResponse searchFlightById(Integer flightId) {
        Optional<Flight> optionalFlight = this.flightRepository.findFlightById(flightId);
        if (optionalFlight.isPresent()) {
            return responseFlight(optionalFlight.get());
        }
        throw new UnregisteredFlightIdException("No flight by the following ID is registered: " + flightId);
    }

    /******
     * Converts the flight domain object into a response
     **/
    private static FlightResponse responseFlight(Flight completedFlight) {
        return new FlightResponse(
                completedFlight.getId(),
                completedFlight.getDepartingFrom(),
                completedFlight.getArrivingTo(),
                completedFlight.getCarrier(),
                completedFlight.getTimeOfDeparture(),
                completedFlight.getTimeOfArrival());
    }

    public FlightSearchResponse getFlights() {
        List<Flight> allFlights = this.flightRepository.getFlights();
        Integer pageCount = (allFlights.isEmpty()) ? 0 : 1;
        return new FlightSearchResponse(pageCount, new LinkedList<Flight>(allFlights));
    }
}