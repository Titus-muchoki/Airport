package dao;

import models.Airport;
import models.Review;

import java.util.List;

public interface ReviewDao {
    //create
    void add(Review review);

    //read
    List<Review> getAll();
    List<Review> getAllReviewsByAirports(int airportId);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}
