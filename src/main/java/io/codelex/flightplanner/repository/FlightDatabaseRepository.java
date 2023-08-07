package io.codelex.flightplanner.repository;

import java.util.List;
import java.util.Optional;

import io.codelex.flightplanner.domain.Airport;
import io.codelex.flightplanner.domain.Flight;
import io.codelex.flightplanner.exceptions.DuplicateFlightException;
import io.codelex.flightplanner.requests.ValidatedFlightSearchRequest;

public class FlightDatabaseRepository implements FlightRepositoryInterface {

    @Override
    public void addFlight(Flight flight) throws DuplicateFlightException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addFlight'");
    }

    @Override
    public List<Flight> getFlights() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFlights'");
    }

    @Override
    public boolean removeFlightById(Integer flightId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFlightById'");
    }

    @Override
    public void clearFlights() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clearFlights'");
    }

    @Override
    public List<Airport> findAirports(String searchParams) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAirports'");
    }

    @Override
    public List<Flight> findFlights(ValidatedFlightSearchRequest searchRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findFlights'");
    }

    @Override
    public Optional<Flight> findFlightById(Integer flightId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findFlightById'");
    }

}
