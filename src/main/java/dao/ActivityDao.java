package dao;

import models.Activities;
import models.Review;

import java.util.List;

public interface ActivityDao {
    //create
    void add(Activities activities);

    //read
    List<Activities> getAll();
    List<Review> getAllActivitiesByAirport(int airportId);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}
