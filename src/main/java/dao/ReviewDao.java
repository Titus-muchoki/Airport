package dao;

import models.Feature;
import models.Review;

import java.util.List;

public interface ReviewDao {
    //create
    void add(Feature feature);

    //read
    List<Review> getAll();
    List<Review> getAllReviewsByAirport(int airportId);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}
