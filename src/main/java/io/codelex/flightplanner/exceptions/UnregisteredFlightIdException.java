package io.codelex.flightplanner.exceptions;

import java.util.NoSuchElementException;

public class UnregisteredFlightIdException extends NoSuchElementException {

    public UnregisteredFlightIdException(String message) {
        super(message);
    }

}
