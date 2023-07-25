package io.codelex.flightplanner.exceptions;

public class InvalidNewFlightRequest extends IllegalArgumentException {
    public InvalidNewFlightRequest(String message) {
        super(message);
    }
}
