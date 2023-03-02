package dao;

import models.Airport;
import models.Feature;


import java.util.List;

public interface FeatureDao {
    //create
    void add(Feature feature);

    //read
    List<Feature> getAll();
    List<Feature> getAllFeaturesByAirports(int airportId);
//    List<Airport> getAllFeaturesByAirportSortedNewestToOldest(int featureId);


    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}
