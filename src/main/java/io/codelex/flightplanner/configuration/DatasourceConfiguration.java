package io.codelex.flightplanner.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfiguration {
    @Bean
    public DataSource getDatabaseDatasource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/postgres")
                .username("codelex-admin")
                .password("Password123")
                .build();
    }
}