package io.codelex.flightplanner.requests;

import java.time.LocalDate;
import java.util.Objects;

import io.codelex.flightplanner.domain.Airport;

public class FlightSearchRequest {
    private Airport departingFrom;
    private Airport arrivingTo;
    private LocalDate dateOfDeparture;

    // Constructor
    public FlightSearchRequest(Airport departingFrom, Airport arrivingTo, LocalDate dateOfDeparture) {
        this.departingFrom = departingFrom;
        this.arrivingTo = arrivingTo;
        this.dateOfDeparture = dateOfDeparture;
    }

    // Setters
    public void setDepartingFrom(Airport departingFrom) {
        this.departingFrom = departingFrom;
    }

    public void setArrivingTo(Airport arrivingTo) {
        this.arrivingTo = arrivingTo;
    }

    public void setDateOfDeparture(LocalDate dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    // Getters
    public Airport getDepartingFrom() {
        return this.departingFrom;
    }

    public Airport getArrivingTo() {
        return this.arrivingTo;
    }

    public LocalDate getDateOfDeparture() {
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
        return Objects.equals(this.departingFrom, request1.departingFrom) &&
                Objects.equals(this.arrivingTo, request1.arrivingTo) &&
                Objects.equals(this.dateOfDeparture, request1.dateOfDeparture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.departingFrom, this.arrivingTo, this.dateOfDeparture);
    }

    @Override
    public String toString() {
        return String.format("FlightSearchRequest{departingFrom=%s, arrivingTo=%s, dateOfDeparture=%s}",
                this.departingFrom, this.arrivingTo, this.dateOfDeparture);
    }
}
