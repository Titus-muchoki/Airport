CREATE DATABASE aircraft;
\c aircraft;
CREATE TABLE airports(id SERIAL PRIMARY KEY, name VARCHAR, code VARCHAR, city VARCHAR, distance VARCHAR);
CREATE TABLE features(id SERIAL PRIMARY KEY, widthrunway VARCHAR, lengthrunway VARCHAR, strengthrunway VARCHAR, airportid INTEGER, createdat BIGINT);
CREATE DATABASE aircraft_test WITH TEMPLATE aircraft;