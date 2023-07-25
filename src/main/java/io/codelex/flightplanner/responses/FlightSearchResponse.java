package io.codelex.flightplanner.responses;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.codelex.flightplanner.domain.Flight;

public class FlightSearchResponse {
    @JsonProperty("page")
    private int pageNumber;
    @JsonProperty("totalItems")
    private int itemsInCurrentPage;
    @JsonProperty("items")
    private List<Flight> listOfFlights = new LinkedList<>();

    // Constructors
    public FlightSearchResponse() {
        this.setPageNumber(0);
        this.setListOfFlights(new LinkedList<>());
    }

    public FlightSearchResponse(int pageNumber, LinkedList<Flight> listOfFlights) {
        this.setPageNumber(pageNumber);
        this.setListOfFlights(listOfFlights);
    }

    // Setters
    public int getPageNumber() {
        return pageNumber;
    }


    public void setListOfFlights(LinkedList<Flight> listOfFlights) {
        this.listOfFlights = listOfFlights;
        this.itemsInCurrentPage = listOfFlights.size();
    }

    public void addToListOfFlights(Flight newFlight) {
        this.listOfFlights.add(newFlight);
        this.itemsInCurrentPage++;
    }

    // Getters
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getItemsInCurrentPage() {
        return itemsInCurrentPage;
    }

    public List<Flight> getListOfFlights() {
        return listOfFlights;
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
        FlightSearchResponse response1 = (FlightSearchResponse) o;
        return Objects.equals(this.getPageNumber(), response1.getPageNumber()) &&
                Objects.equals(this.getItemsInCurrentPage(), response1.getItemsInCurrentPage()) &&
                Objects.equals(this.getListOfFlights(), response1.getListOfFlights());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getPageNumber(), this.getItemsInCurrentPage(), this.getListOfFlights());
    }

    @Override
    public String toString() {
        return String.format(
                "FlightSearchResponse{pageNumber=%d, itemsInCurrentPage=%d, listOfFlights=%s}",
                this.getPageNumber(), this.getItemsInCurrentPage(), this.getListOfFlights().toString());
    }
}
