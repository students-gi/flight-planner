package io.codelex.flightplanner.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.codelex.flightplanner.repository.FlightDatabaseRepository;
import io.codelex.flightplanner.repository.FlightInMemoryRepository;
import io.codelex.flightplanner.repository.FlightRepositoryInterface;

@Configuration
public class FlightRepositoryConfiguration {

    @Value("${flightplanner.repository.version}")
    private String repoVersion;

    @Bean
    public FlightRepositoryInterface setFlightRepository() {
        if (repoVersion.equalsIgnoreCase("in-memory")) {
            return new FlightInMemoryRepository();
        }
        else if (repoVersion.equalsIgnoreCase("database")) {
            return new FlightDatabaseRepository();
        }
        else {
            throw new RuntimeException(
                    "Incorrect configuration for flightplanner.repository.version: " + this.repoVersion);
        }
    }
}
