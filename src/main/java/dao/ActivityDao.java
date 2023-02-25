package dao;

import models.Activity;
import models.Review;

import java.util.List;

public interface ActivityDao {
    //create
    void add(Activity activity);

    //read
    List<Activity> getAll();
    List<Review> getAllActivitiesByAirport(int airportId);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}
