# Using the official PostgreSQL 15 Alpine image as the base image
FROM postgres:15-alpine

# Environment variables for database setup
ENV POSTGRES_DB flightplanner
ENV POSTGRES_USER codelex-admin
ENV POSTGRES_PASSWORD Password123

# Exposing the PostgreSQL default port
EXPOSE 5432
