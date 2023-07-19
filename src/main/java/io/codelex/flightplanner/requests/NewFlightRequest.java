package io.codelex.flightplanner.requests;

import java.time.LocalDateTime;
import java.util.Objects;

import io.codelex.flightplanner.domain.Airport;

public class NewFlightRequest {
    private Airport departingFrom;
    private Airport arrivingTo;
    private String carrier;
    private LocalDateTime timeOfDeparture;
    private LocalDateTime timeOfArrival;

    public NewFlightRequest(Airport departingFrom, Airport arrivingTo, String carrier,
            LocalDateTime timeOfDeparture, LocalDateTime timeOfArrival) {
        this.setDepartingFrom(departingFrom);
        this.setArrivingTo(arrivingTo);
        this.setCarrier(carrier);
        this.setTimeOfDeparture(timeOfDeparture);
        this.setTimeOfArrival(timeOfArrival);
    }

    // Setters
    public void setDepartingFrom(Airport departingFrom) {
        this.departingFrom = departingFrom;
    }

    public void setArrivingTo(Airport arrivingTo) {
        this.arrivingTo = arrivingTo;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public void setTimeOfDeparture(LocalDateTime timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    public void setTimeOfArrival(LocalDateTime timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }

    // Getters
    public Airport getDepartingFrom() {
        return this.departingFrom;
    }

    public Airport getArrivingTo() {
        return this.arrivingTo;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public LocalDateTime getTimeOfDeparture() {
        return this.timeOfDeparture;
    }

    public LocalDateTime getTimeOfArrival() {
        return this.timeOfArrival;
    }

    // Default method overrides
    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        if (this == o) {
            return true;
        }
        NewFlightRequest flight = (NewFlightRequest) o;
        return Objects.equals(this.departingFrom, flight.departingFrom) &&
                Objects.equals(this.arrivingTo, flight.arrivingTo) &&
                Objects.equals(this.carrier, flight.carrier) &&
                Objects.equals(this.timeOfDeparture, flight.timeOfDeparture) &&
                Objects.equals(this.timeOfArrival, flight.timeOfArrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.departingFrom, this.arrivingTo, this.carrier, this.timeOfDeparture,
                this.timeOfArrival);
    }

    @Override
    public String toString() {
        return String.format(
                "Flight{departingFrom=%s, arrivingTo=%s, carrier='%s', timeOfDeparture=%s, timeOfArrival=%s}",
                this.departingFrom, this.arrivingTo, this.carrier, this.timeOfDeparture, this.timeOfArrival);
    }

}
