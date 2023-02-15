package dao;

import models.Airport;

import java.util.List;

public interface AirportDao {

    // CREATE
    void add(Airport airport);

    // READ
    List<Airport> getAll();


    Airport findById(int id);

    // UPDATE
    void update(int id, String name, String code, String city, String distance);

    // DELETE
    void deleteById(int id);

    void clearAll();
}
