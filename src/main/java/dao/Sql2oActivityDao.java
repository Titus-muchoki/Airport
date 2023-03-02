package dao;

import models.Activity;
import models.Airport;
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
        String sql = "INSERT INTO activities(inspectiondate, inspectionarea, inspectionoutcome,serviceabilitystatus,airportId)VALUES(:inspectionDate, :inspectionArea, :inspectionOutcome, :serviceAbilityStatus, :airportId)";
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
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM activities")
                    .executeAndFetch(Activity.class);
        }
    }

    @Override
    public List<Activity> getAllActivitysByAirport(int airportId) {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM activities WHERE airportId = :airportId")
                    .addParameter("airportId", airportId)
                    .executeAndFetch(Activity.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from activities WHERE id = :id";
        try (Connection con = sql2o.open()){
            con.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
    String sql = "DELETE from activities";
    try(Connection con = sql2o.open()){
        con.createQuery(sql, true)
                .executeUpdate();
    }catch (Sql2oException ex){
        System.out.println(ex);
    }
    }
}
