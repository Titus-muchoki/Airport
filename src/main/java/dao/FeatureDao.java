package dao;

import models.Feature;
import models.Review;

import java.util.List;

public interface FeatureDao {
    //create
    void add(Feature feature);

    //read
    List<Feature> getAll();
    List<Feature> getAllFeaturesByAirport(int airportId);
    List<Feature> getAllFeaturesByAirportSortedNewestToOldest(int airportId);


    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}
