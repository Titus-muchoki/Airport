package dao;

import models.Activity;
import models.Airport;

import java.util.List;

public interface ActivityDao {
    //create
    void add(Activity activity);

    //read
    List<Activity> getAll();
    List<Activity> getAllActivitysByAirport(int airportId);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}
