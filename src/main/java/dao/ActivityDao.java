package dao;

import models.Activity;
import java.util.List;

public interface ActivityDao {
    //create
    void add(Activity activity);

    //read
    List<Activity> getAll();
    List<Activity> getAllActivitiesByAirport(int airportId);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}
