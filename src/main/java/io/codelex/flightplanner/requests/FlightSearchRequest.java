package io.codelex.flightplanner.requests;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public class FlightSearchRequest {
    @Valid
    @NotBlank
    @JsonProperty("from")
    private String departingFrom;
    @Valid
    @NotBlank
    @JsonProperty("to")
    private String arrivingTo;
    @Valid
    @NotBlank
    @JsonProperty("departureDate")
    private String dateOfDeparture;

    // Constructor
    public FlightSearchRequest(){
    }

    public FlightSearchRequest(String departingFrom, String arrivingTo, String dateOfDeparture) {
        this.setDepartingFrom(departingFrom);
        this.setArrivingTo(arrivingTo);
        this.setDateOfDeparture(dateOfDeparture);
    }

    // Setters
    public void setDepartingFrom(String departingFrom) {
        this.departingFrom = departingFrom;
    }

    public void setArrivingTo(String arrivingTo) {
        this.arrivingTo = arrivingTo;
    }

    public void setDateOfDeparture(String dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    // Getters
    public String getDepartingFrom() {
        return this.departingFrom;
    }

    public String getArrivingTo() {
        return this.arrivingTo;
    }

    public String getDateOfDeparture() {
        return this.dateOfDeparture;
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
        FlightSearchRequest request1 = (FlightSearchRequest) o;
        return Objects.equals(this.getDepartingFrom(), request1.getDepartingFrom()) &&
                Objects.equals(this.getArrivingTo(), request1.getArrivingTo()) &&
                Objects.equals(this.getDateOfDeparture(), request1.getDateOfDeparture());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getDepartingFrom(), this.getArrivingTo(), this.getDateOfDeparture());
    }

    @Override
    public String toString() {
        return String.format("FlightSearchRequest{departingFrom=%s, arrivingTo=%s, dateOfDeparture=%s}",
                this.getDepartingFrom(), this.getArrivingTo(), this.getDateOfDeparture());
    }
}
