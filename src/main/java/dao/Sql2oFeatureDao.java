package dao;

import models.Airport;
import models.Feature;
import models.Review;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oFeatureDao implements FeatureDao {

    private final Sql2o sql2o;

    public Sql2oFeatureDao( Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Feature feature) {
        String sql = "INSERT INTO features (widthrunway, lengthrunway, strengthrunway,airportId) VALUES (:widthRunWay, :lengthRunWay, :strengthRunWay, :airportId)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(feature)
                    .executeUpdate()
                    .getKey();
            feature.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<Feature> getAll() {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM features")
                    .executeAndFetch(Feature.class);
        }
    }

    @Override
    public List<Feature> getAllFeaturesByAirports(int airportId) {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM features WHERE airportId = :airportId")
                    .addParameter("airportId", airportId)
                    .executeAndFetch(Feature.class);
        }
    }


//    @Override
//    public List<Airport> getAllFeaturesByAirportSortedNewestToOldest(int featureId) {
//        List<Airport> unsortedFeatures = getAllFeaturesByAirportSortedNewestToOldest( featureId);
//        List<Airport> sortedFeatures = unsortedFeatures;
//        return sortedFeatures;
//    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from features WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void clearAll() {
        String sql = "DELETE from features";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
