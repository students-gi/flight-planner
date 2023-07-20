package io.codelex.flightplanner.domain;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.codelex.flightplanner.utils.StringFormatter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Airport {
    @NotBlank
    @NotNull
    @JsonProperty("country")
    private String country;
    @NotBlank
    @NotNull
    @JsonProperty("city")
    private String city;
    @NotBlank
    @NotNull
    @JsonProperty("airport")
    private String id;

    // Constructors
    public Airport() {
    }

    public Airport(String country, String city, String id) {
        this.setCountry(country);
        this.setCity(city);
        this.setId(id);
    }

    // Setters
    public void setCountry(String country) {
        this.country = StringFormatter.toTitleCase(country).trim();
    }

    public void setCity(String city) {
        this.city = StringFormatter.toTitleCase(city).trim();
    }

    public void setId(String id) {
        // https://www.wikipedia.org/wiki/IATA_airport_code?lang=en
        this.id = id.toUpperCase().trim();
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
