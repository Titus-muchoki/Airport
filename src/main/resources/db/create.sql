CREATE DATABASE aircraft;
\c aircraft;
CREATE TABLE airports(id SERIAL PRIMARY KEY, name VARCHAR, code VARCHAR, city VARCHAR, distance VARCHAR);
CREATE DATABASE aircraft_test WITH TEMPLATE aircraft;