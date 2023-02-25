package dao;

import models.Activity;
import models.Review;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oActivityDao implements ActivityDao{
    public Sql2o sql2o;
    public Sql2oActivityDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Activity activity) {
        String sql = "INSERT INTO activities(inspectiondate, inspectionarea, inspectionoutcome,serviceabilitystatus,airportid)VALUES(:inspectionDate, :inspectionArea, :inspectionOutcome, :serviceAbilityStatus, :airportId)";
        try(Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(activity)
                    .executeUpdate()
                    .getKey();
            activity.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);


        }

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
