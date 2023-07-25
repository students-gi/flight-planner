package io.codelex.flightplanner.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Flight {
    @NotBlank
    @NotNull
    private Integer id;
    @Valid
    @NotNull
    private Airport departingFrom;
    @Valid
    @NotNull
    private Airport arrivingTo;
    @NotBlank
    @NotNull
    private String carrier;
    @NotBlank
    @NotNull
    private LocalDateTime datetimeOfDeparture;
    @NotBlank
    @NotNull
    private LocalDateTime datetimeOfArrival;

    // Constructors
    public Flight(Airport departingFrom, Airport arrivingTo, String carrier,
            LocalDateTime datetimeOfDeparture, LocalDateTime datetimeOfArrival) {
        this.setDepartingFrom(departingFrom);
        this.setArrivingTo(arrivingTo);
        this.setCarrier(carrier);
        this.setTimeOfDeparture(datetimeOfDeparture);
        this.setTimeOfArrival(datetimeOfArrival);
        this.setId();
    }

    public Flight(Integer id, Airport departingFrom, Airport arrivingTo, String carrier,
            LocalDateTime datetimeOfDeparture, LocalDateTime datetimeOfArrival) {
        this.setId(id);
        this.setDepartingFrom(departingFrom);
        this.setArrivingTo(arrivingTo);
        this.setCarrier(carrier);
        this.setTimeOfDeparture(datetimeOfDeparture);
        this.setTimeOfArrival(datetimeOfArrival);
    }

    // Setters
    private void setId(Integer id) {
        this.id = id;
    }

    private void setId() {
        this.id = 42;
        this.id = this.hashCode();
    }

    public void setDepartingFrom(Airport departingFrom) {
        this.departingFrom = departingFrom;
    }

    public void setArrivingTo(Airport arrivingTo) {
        this.arrivingTo = arrivingTo;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public void setTimeOfDeparture(LocalDateTime datetimeOfDeparture) {
        this.datetimeOfDeparture = datetimeOfDeparture;
    }

    public void setTimeOfArrival(LocalDateTime datetimeOfArrival) {
        this.datetimeOfArrival = datetimeOfArrival;
    }

    // Getters
    public Integer getId() {
        return this.id;
    }

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
        return this.datetimeOfDeparture;
    }

    public LocalDateTime getTimeOfArrival() {
        return this.datetimeOfArrival;
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
        Flight flight = (Flight) o;
        return Objects.equals(this.id, flight.id) &&
                Objects.equals(this.departingFrom, flight.departingFrom) &&
                Objects.equals(this.arrivingTo, flight.arrivingTo) &&
                Objects.equals(this.carrier, flight.carrier) &&
                Objects.equals(this.datetimeOfDeparture, flight.datetimeOfDeparture) &&
                Objects.equals(this.datetimeOfArrival, flight.datetimeOfArrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.departingFrom, this.arrivingTo, this.carrier,
                this.datetimeOfDeparture, this.datetimeOfArrival);
    }

    @Override
    public String toString() {
        return String.format(
                "Flight{id=%d, departingFrom=%s, arrivingTo=%s, carrier='%s', datetimeOfDeparture=%s, datetimeOfArrival=%s}",
                this.id, this.departingFrom, this.arrivingTo, this.carrier,
                this.datetimeOfDeparture, this.datetimeOfArrival);
    }

}
