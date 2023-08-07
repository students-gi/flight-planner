package io.codelex.flightplanner.repository;

import java.util.List;
import java.util.Optional;

import io.codelex.flightplanner.domain.Airport;
import io.codelex.flightplanner.domain.Flight;
import io.codelex.flightplanner.exceptions.DuplicateFlightException;
import io.codelex.flightplanner.requests.ValidatedFlightSearchRequest;

public interface FlightRepositoryInterface {
    /**
     * Adds a new flight to the repository.
     *
     * @param flight The flight to be added.
     * @throws DuplicateFlightException If a flight with the same details already exists.
     */
    public void addFlight(Flight flight) throws DuplicateFlightException;

    /**
     * Retrieves a list of all flights in the repository.
     *
     * @return A list of flights.
     */
    public List<Flight> getFlights();

    /**
     * Removes a flight from the repository by its ID.
     *
     * @param flightId The ID of the flight to be removed.
     * @return {@code true} if the flight was removed successfully, otherwise {@code false}.
     */
    public boolean removeFlightById(Integer flightId);

    /**
     * Clears all flights from the repository.
     */
    public void clearFlights();

    /**
     * Finds airports that match the provided search parameters.
     *
     * @param searchParams The search parameters.
     * @return A linked list of matching airports.
     */
    public List<Airport> findAirports(String searchParams);

    /**
     * Finds flights that match the provided search request.
     *
     * @param searchRequest The validated flight search request.
     * @return A linked list of matching flights.
     */
    public List<Flight> findFlights(ValidatedFlightSearchRequest searchRequest);

    /**
     * Finds a flight in the repository by its ID.
     *
     * @param flightId The ID of the flight to be found.
     * @return An optional containing the found flight, or an empty optional if not found.
     */
    public Optional<Flight> findFlightById(Integer flightId);
}
