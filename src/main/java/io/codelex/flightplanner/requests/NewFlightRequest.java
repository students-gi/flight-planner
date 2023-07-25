package io.codelex.flightplanner.requests;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.codelex.flightplanner.domain.Airport;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NewFlightRequest {
    @Valid
    @NotNull
    @JsonProperty("from")
    private Airport departingFrom;
    @Valid
    @NotNull
    @JsonProperty("to")
    private Airport arrivingTo;
    @NotBlank
    @NotNull
    @JsonProperty("carrier")
    private String carrier;
    @NotBlank
    @NotNull
    @JsonProperty("departureTime")
    private String timeOfDeparture;
    @NotBlank
    @NotNull
    @JsonProperty("arrivalTime")
    private String timeOfArrival;

    // Constructors
    public NewFlightRequest() {
    }

    public NewFlightRequest(Airport departingFrom, Airport arrivingTo, String carrier,
            String timeOfDeparture, String timeOfArrival) {
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

    public void setTimeOfDeparture(String timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    public void setTimeOfArrival(String timeOfArrival) {
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
