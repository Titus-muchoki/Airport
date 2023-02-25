package dao;

import models.Activity;
import models.Review;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oActivityDao implements ActivityDao{
    public Sql2o sql2o;
    public Sql2oActivityDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Activity activity) {
        String sql = "INSERT INTO activities()VALUES()";

    }

    @Override
    public List<Activity> getAll() {
        return null;
    }
    @Override
    public List<Review> getAllActivitiesByAirport(int airportId) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
