package io.codelex.flightplanner.exceptions;

public class InvalidFlightSearchRequest extends IllegalArgumentException {
    public InvalidFlightSearchRequest(String message) {
        super(message);
    }
}
