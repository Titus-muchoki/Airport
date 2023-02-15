package dao;

import models.Feature;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oFeatureDao implements FeatureDao {

    private final Sql2o sql2o;

    public Sql2oFeatureDao( Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Feature feature) {

    }

    @Override
    public List<Feature> getAll() {
        return null;
    }

    @Override
    public List<Feature> getAllFeaturesByAirport(int airportId) {
        return null;
    }

    @Override
    public List<Feature> getAllFeaturesByAirportSortedNewestToOldest(int airportId) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAll() {

    }
}
