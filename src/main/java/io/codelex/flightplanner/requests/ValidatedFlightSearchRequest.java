package io.codelex.flightplanner.requests;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import io.codelex.flightplanner.domain.Airport;

public class ValidatedFlightSearchRequest {
    private List<Airport> departingFromList;
    private List<Airport> arrivingToList;
    private LocalDate dateOfDeparture;

    // Constructors
    public ValidatedFlightSearchRequest() {
    }

    public ValidatedFlightSearchRequest(List<Airport> departingFromList, List<Airport> arrivingToList, LocalDate dateOfDeparture) {
        this.setDepartingFromList(departingFromList);
        this.setArrivingToList(arrivingToList);
        this.setDateOfDeparture(dateOfDeparture);
    }

    // Setters
    public void setDepartingFromList(List<Airport> departingFromList) {
        this.departingFromList = departingFromList;
    }

    public void setArrivingToList(List<Airport> arrivingToList) {
        this.arrivingToList = arrivingToList;
    }

    public void setDateOfDeparture(LocalDate dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    // Getters
    public List<Airport> getDepartingFromList() {
        return this.departingFromList;
    }

    public List<Airport> getArrivingToList() {
        return this.arrivingToList;
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
        ValidatedFlightSearchRequest request1 = (ValidatedFlightSearchRequest) o;
        return Objects.equals(this.getDepartingFromList(), request1.getDepartingFromList()) &&
                Objects.equals(this.getArrivingToList(), request1.getArrivingToList()) &&
                Objects.equals(this.getDateOfDeparture(), request1.getDateOfDeparture());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getDepartingFromList(), this.getArrivingToList(), this.getDateOfDeparture());
    }

    @Override
    public String toString() {
        return String.format("ValidatedFlightSearchRequest{departingFromList=%s, arrivingToList=%s, dateOfDeparture=%s}",
                this.getDepartingFromList(), this.getArrivingToList(), this.getDateOfDeparture());
    }
}
