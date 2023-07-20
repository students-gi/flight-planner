package io.codelex.flightplanner.responses;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.codelex.flightplanner.domain.Airport;
import io.codelex.flightplanner.utils.LocalDateTimeFormatter;

public class NewFlightResponse {
    @JsonProperty("from")
    private Airport departingFrom;
    @JsonProperty("to")
    private Airport arrivingTo;
    @JsonProperty("carrier")
    private String carrier;
    @JsonProperty("departureTime")
    private String timeOfDeparture;
    @JsonProperty("arrivalTime")
    private String timeOfArrival;
    @JsonProperty("id")
    private int id;

    // Constructors
    public NewFlightResponse() {
    }

    public NewFlightResponse(int id, Airport departingFrom, Airport arrivingTo, String carrier,
            LocalDateTime timeOfDeparture, LocalDateTime timeOfArrival) {
        this.setDepartingFrom(departingFrom);
        this.setArrivingTo(arrivingTo);
        this.setCarrier(carrier);
        this.setTimeOfDeparture(timeOfDeparture);
        this.setTimeOfArrival(timeOfArrival);
        this.setId(id);
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
        this.timeOfDeparture = LocalDateTimeFormatter.localDateTimeToString(timeOfDeparture);
    }

    public void setTimeOfArrival(LocalDateTime timeOfArrival) {
        this.timeOfArrival = LocalDateTimeFormatter.localDateTimeToString(timeOfArrival);
    }

    private void setId(int id) {
        this.id = id;
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

    public String getTimeOfDeparture() {
        return this.timeOfDeparture;
    }

    public String getTimeOfArrival() {
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
        NewFlightResponse flight = (NewFlightResponse) o;
        return Objects.equals(this.departingFrom, flight.departingFrom) &&
                Objects.equals(this.arrivingTo, flight.arrivingTo) &&
                Objects.equals(this.carrier, flight.carrier) &&
                Objects.equals(this.timeOfDeparture, flight.timeOfDeparture) &&
                Objects.equals(this.timeOfArrival, flight.timeOfArrival) &&
                Objects.equals(this.id, flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.departingFrom, this.arrivingTo, this.carrier,
                this.timeOfDeparture, this.timeOfArrival, this.id);
    }

    @Override
    public String toString() {
        return String.format(
                "Flight{id=%d, from=%s, to=%s, carrier='%s', departureTime=%s, arrivalTime=%s}",
                this.id, this.departingFrom, this.arrivingTo, this.carrier, this.timeOfDeparture, this.timeOfArrival);
    }
}
