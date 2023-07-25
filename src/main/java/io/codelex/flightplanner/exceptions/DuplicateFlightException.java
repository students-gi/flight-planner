package io.codelex.flightplanner.exceptions;

public class DuplicateFlightException extends IllegalArgumentException {
    public DuplicateFlightException(String message) {
        super(message);
    }
}
