package io.codelex.flightplanner.domain;

import java.util.Objects;

public class Airport {
    private String country;
    private String city;
    private String id;

    // Constructor
    public Airport(String country, String city, String id) {
        this.setCountry(country);
        this.setCity(city);
        this.setId(id);
    }

    // Setters
    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setId(String id) {
        // https://www.wikipedia.org/wiki/IATA_airport_code?lang=en
        this.id = id.toUpperCase();
    }

    // Getters
    public String getCountry() {
        return this.country;
    }

    public String getCity() {
        return this.city;
    }

    public String getId() {
        return this.id;
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
        Airport airport1 = (Airport) o;
        return Objects.equals(this.country, airport1.country) &&
                Objects.equals(this.city, airport1.city) &&
                Objects.equals(this.id, airport1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.country, this.city, this.id);
    }

    @Override
    public String toString() {
        return String.format(
                "Airport{country='%s', city='%s', id='%s'}",
                this.country, this.city, this.id);
    }

}
