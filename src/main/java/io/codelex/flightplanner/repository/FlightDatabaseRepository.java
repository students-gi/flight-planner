package io.codelex.flightplanner.repository;

import java.util.List;
import java.util.Optional;

import io.codelex.flightplanner.domain.Airport;
import io.codelex.flightplanner.domain.Flight;
import io.codelex.flightplanner.exceptions.DuplicateFlightException;
import io.codelex.flightplanner.requests.ValidatedFlightSearchRequest;

public class FlightDatabaseRepository implements FlightRepositoryInterface {
    private final DatabaseTableAirports tableAirports;
    private final DatabaseTableFlights tableFlights;

    public FlightDatabaseRepository(DatabaseTableAirports tableAirports, DatabaseTableFlights tableFlights) {
        this.tableAirports = tableAirports;
        this.tableFlights = tableFlights;
    }

    @Override
    public synchronized Flight addFlight(Flight flight) throws DuplicateFlightException {
        if (this.tableFlights.existsExact(flight)) {
            throw new DuplicateFlightException("Flight with the following details already exists: " + flight);
        }

        Airport airport1 = flight.getDepartingFrom();
        if (!this.tableAirports.existsExact(airport1)) {
            this.tableAirports.save(airport1);
        }
        Airport airport2 = flight.getArrivingTo();
        if (!this.tableAirports.existsExact(airport2)) {
            this.tableAirports.save(airport2);
        }
        return this.tableFlights.save(flight);
    }

    @Override
    public List<Flight> getFlights() {
        return this.tableFlights.findAll();
    }

    @Override
    public boolean removeFlightById(Integer flightId) {
        if (this.tableFlights.existsById(flightId)) {
            this.tableFlights.deleteById(flightId);
            return true;
        }
        return false;
    }

    @Override
    public void clearFlights() {
        this.tableFlights.deleteAll();
        this.tableAirports.deleteAll();
    }

    @Override
    public List<Airport> findAirports(String searchParams) {
        return this.tableAirports.searchAirport(searchParams.trim().toUpperCase());
    }

    @Override
    public List<Flight> findFlights(ValidatedFlightSearchRequest searchRequest) {
        return this.tableFlights.searchFlight(searchRequest);
    }

    @Override
    public Optional<Flight> findFlightById(Integer flightId) {
        return this.tableFlights.findById(flightId);
    }

}
