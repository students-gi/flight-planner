--liquibase formatted sql

--changeset GatisIevins:1
CREATE TABLE Airports (
    id      VARCHAR(5)      PRIMARY KEY,
    country VARCHAR(255)    NOT NULL,
    city    VARCHAR(255)    NOT NULL
);

CREATE TABLE Flights (
    id                  SERIAL          PRIMARY KEY,
    departing_from      VARCHAR(5)      NOT NULL,
    arriving_to         VARCHAR(5)      NOT NULL,
    carrier             VARCHAR(255)    NOT NULL,
    datetime_departure  TIMESTAMP       NOT NULL,
    datetime_arrival    TIMESTAMP       NOT NULL,

    FOREIGN KEY (departing_from) REFERENCES Airports(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (arriving_to) REFERENCES Airports(id) ON DELETE CASCADE ON UPDATE CASCADE
);